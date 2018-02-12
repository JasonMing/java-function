package com.github.jasonming.java.function.generator

/**
 * Generate "[(typeX nameX), ..., (typeN nameN)]" sequence.
 *
 * @param start start number.
 * @param end   end number, included.
 */
fun parameters(start: Int, end: Int): Sequence<Parameter> =
    (start..end)
        .asSequence()
        .map { Parameter(it) }
        .withToString()

/**
 * Generate "[(type1 name1), ..., (typeN nameN)]" sequence.
 *
 * @param end end number, included.
 */
fun parameters(end: Int): Sequence<Parameter> = parameters(1, end)

/**
 * Generate "[$nameX, ..., $nameN]" sequence.
 *
 * @param name  argument name.
 * @param start start number.
 * @param end   end number, included.
 */
fun arguments(name: String, start: Int, end: Int): Sequence<String> =
    (start..end)
        .asSequence()
        .map { "$name$it" }
        .withToString()

/**
 * Generate "[pX, ..., pN]" sequence.
 *
 * @param start start number.
 * @param end   end number, included.
 */
fun arguments(start: Int, end: Int): Sequence<String> = arguments(PARAMETER_NAME_PREFIX, start, end)

/**
 * Generate "[p1, ..., pN]" sequence.
 *
 * @param end  end number, included.
 */
fun arguments(end: Int): Sequence<String> = arguments(1, end)

/**
 * Generate "[typeX, ..., typeN, ($last)]" sequence.
 *
 * @param start start number.
 * @param end   end number, included.
 * @param last  the item to append, optional
 */
fun parameterTypes(start: Int, end: Int, last: String? = null): Sequence<String> =
    parameters(start, end)
        .map { it.type }
        .run { last?.let { this.plus(it) } ?: this }
        .withToString()

/**
 * Generate "[type1, ..., typeN, ($last)]" sequence.
 *
 * @param end  end number, included.
 * @param last the item to append, optional
 */
fun parameterTypes(end: Int, last: String? = null): Sequence<String> = parameterTypes(1, end, last)

/**
 * Generate nested string like "this[n](...(this[0]($identity)))".
 */
fun <T> Sequence<T>.nestToString(identity: String, accumulator: (@ParameterName("acc") String, @ParameterName("it") T) -> String): String = this.fold(identity, accumulator)

fun <T> T.letIf(condition: Boolean, block: (T) -> T): T = if (condition) this.let(block) else this
fun <T> Sequence<T>.plusIfNotNull(element: T?): Sequence<T> = element?.let { this.plusElement(it) } ?: this

fun Sequence<String>.removeOverride() = this.filter { "@Override" !in it }

fun <T> Sequence<T>.withToString(toStringFunc: Sequence<T>.() -> String): Sequence<T> = object : Sequence<T> by this
{
    override fun toString(): String = this.toStringFunc()
}

fun <T> Sequence<T>.withToString(): Sequence<T> = this.withToString { this.joinToString() }

fun Sequence<MemberBody>.expand(): Sequence<String> = if (this.none()) emptySequence() else this.reduce { acc, x -> acc + sequenceOf("") + x }

// region: Generate extension of FunctionDefinition

fun ((Int) -> FunctionDefinition).generateAll(range: IntRange = (0..9), commonProcess: Boolean = true): List<FunctionDefinition> =
    range
        .map { this(it) }
        .letIf(commonProcess) {
            it.apply {
                // Remove "apply" on [0, 1]
                this.subList(0, 2).forEach { it.members -= "apply" }
                // this.subList(FUNCTIONS_RANGE.last - 1, FUNCTIONS_RANGE.last).forEach { it.members -= "extend" }
            }
        }


fun List<FunctionDefinition>.applyOn(index: Int, block: FunctionDefinition.() -> Unit) =
    this.apply { this[index].block() }

fun List<FunctionDefinition>.toMap() =
    this.mapIndexed { i, it -> "${it.declaration.javaType}${if (i > 0) i.toString() else ""}" to it.toString() }
        .toMap()

// endregion