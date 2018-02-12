/*
 * Copyright (c) 2018 JasonMing All Rights Reserved.
 */

package com.github.jasonming.java.function.generator

import java.lang.Throwable
import kotlin.reflect.KClass

const val PARAMETER_TYPE_PREFIX = "P"
const val PARAMETER_NAME_PREFIX = "p"
const val RETURN_TYPE_NAME = "R"
const val EXCEPTION_TYPE_NAME = "X"
val LINE_ENDING = System.getProperty("line.separator")!!

typealias ClassBody = Map<String, MemberBody>
typealias MemberBody = Sequence<String>

enum class FunctionType
(
    val type: String,
    val hasReturn: Boolean,
    val returnType: String,
    val returnGenericType: String?
)
{
    Func("Func", true, RETURN_TYPE_NAME, RETURN_TYPE_NAME),

    Action("Action", false, "void", null),
}

data class FunctionDeclaration
(
    val argSize: Int,
    private val funcType: FunctionType,
    private val javaTypeSuffix: String? = null,
    private val overrideReturnType: String? = null,
    private val throwType: GenericParameter? = null,
    private val argStart: Int = 1
)
{
    val type: String
        get() = this.funcType.type

    val javaType: String = this.type + (this.javaTypeSuffix ?: "")

    val returnType: String
        get() = this.overrideReturnType ?: this.funcType.returnType

    val genericParameters: GenericParameters = GenericParameters(
        args = parameters(this.argStart, this.argStart + this.argSize - 1),
        ret = this.overrideReturnType ?: this.funcType.returnGenericType,
        thr = this.throwType
    )

    val rawType: String = "${this.javaType}${if (this.argSize > 0) this.argSize.toString() else ""}"

    val genericType: String = this.rawType.letIf(this.genericParameters.all.any()) { "$it<${this.genericParameters}>" }

    private constructor(func: FunctionDeclaration, argSize: Int, argStart: Int = 1)
        : this(argSize, func.funcType, func.javaTypeSuffix, func.returnType, func.throwType, argStart)

    fun reduce(delta: Int, start: Int = 1): FunctionDeclaration = this.copy(argSize = this.argSize - delta, argStart = start)
    fun reduceL(delta: Int = 1): FunctionDeclaration = this.reduce(delta, this.argStart + delta)
    fun reduceR(delta: Int = 1): FunctionDeclaration = this.reduce(delta)

    fun extend(delta: Int = 1): FunctionDeclaration = this.copy(argSize = this.argSize + delta)

    override fun toString(): String = this.genericType

    companion object
    {
        fun Action(x: Int) = FunctionDeclaration(x, FunctionType.Action)
        fun ActionE(x: Int) = FunctionDeclaration(x, FunctionType.Action, javaTypeSuffix = "E")
        fun ActionX(x: Int) = FunctionDeclaration(x, FunctionType.Action, javaTypeSuffix = "X", throwType = GenericParameter.THROWABLE)
        fun Func(x: Int) = FunctionDeclaration(x, FunctionType.Func)
        fun FuncE(x: Int) = FunctionDeclaration(x, FunctionType.Func, javaTypeSuffix = "E")
        fun FuncX(x: Int) = FunctionDeclaration(x, FunctionType.Func, javaTypeSuffix = "X", throwType = GenericParameter.THROWABLE)
    }
}

data class FunctionDefinition
(
    val declaration: FunctionDeclaration,
    val base: FunctionDeclaration? = null,
    val members: LinkedHashMap<String /* Region */, MemberBody /* member(s) */> = linkedMapOf(),
    val extends: LinkedHashSet<String> = linkedSetOf(),
    val imports: LinkedHashSet<String> = linkedSetOf()
    )
{
    lateinit var javadoc: String

    private fun superTypes() =
        (this.base?.let { sequenceOf(it) } ?: emptySequence())
            .plus(this.extends)
            .toList()

    override fun toString(): String
    {
        val superTypes = this.superTypes()
        IndentWriter().use { writer ->

            // imports
            if (this.imports.isNotEmpty())
            {
                this.imports.forEach {
                    writer.appendln("import ${it.trimStart().trimEnd { it.isWhitespace() || it == ';' }};")
                }
                writer.appendln()
                writer.appendln()
            }

            // javadoc
            if (this.javadoc.isNotBlank())
            {
                writer.appendln("/**")
                javadoc.split('\n').forEach {
                    writer.appendln(" * $it")
                }
                writer.appendln(" */")
            }

            // header
            writer.appendln("@FunctionalInterface")
            writer.append("public interface ")
            writer.append(this.declaration.genericType)
            writer.appendln()
            if (superTypes.isNotEmpty())
            {
                writer.writeIndent(2)
                writer.append("extends ")
                writer.append(superTypes.joinToString())
                writer.appendln()
            }

            // body
            writer.withinBlock { w ->
                this.members.values.forEach { member ->
                    member.toList().apply {
                        if (this.isNotEmpty())
                        {
                            this.forEach { w.appendln(it) }
                            w.appendln()
                        }
                    }
                }

                // Remove tailing white character
                val trimSize = w.buffer.reversed().takeWhile { it.isWhitespace() }.count()
                w.buffer.delete(w.buffer.length - trimSize, w.buffer.length)
                w.appendln()
            }

            return writer.toString()
        }
    }
}

data class Parameter
(
    val i: Int,
    val final: Boolean = true
)
{
    val type: String = "${PARAMETER_TYPE_PREFIX}$i"

    val name: String = "${PARAMETER_NAME_PREFIX}$i"

    override fun toString(): String
        = "$type $name".letIf(final) { "final " + it }
}

fun Sequence<Parameter>.mapToType() = this.map { it.type }.withToString()
fun Sequence<Parameter>.mapToName() = this.map { it.name }.withToString()
fun Sequence<Parameter>.final(final: Boolean = true) = this.map { it.copy(final = final) }.withToString()

class GenericParameters
(
    args: Sequence<Parameter>,
    val ret: String?,
    val thr: GenericParameter?
)
{
    val args: Sequence<Parameter> = args
        .toList()
        .asSequence()
        .withToString()

    val all: Sequence<String> = this.args
        .mapToType()
        .plusIfNotNull(this.ret)
        .plusIfNotNull(this.thr?.toString())
        .toList()
        .asSequence()
        .withToString()

    override fun toString(): String = this.all.
        joinToString()
}

data class GenericParameter
(
    val type: String,
    val extends: KClass<*>? = null
)
{
    override fun toString(): String = if (this.extends != null)
    {
        "${this.type} extends ${this.extends.simpleName}"
    } else
    {
        this.type
    }

    companion object
    {
        val THROWABLE: GenericParameter = GenericParameter(EXCEPTION_TYPE_NAME, Throwable::class)
    }
}
