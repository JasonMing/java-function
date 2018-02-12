/*
 * Copyright (c) 2018 JasonMing All Rights Reserved.
 */

package com.github.jasonming.java.function.generator

fun invoke(func: FunctionDeclaration,
           override: Boolean = false,
           annotations: Array<String> = emptyArray(),
           javadoc: String = "",
           vararg body: String)
    : MemberBody
{
    val throwClause = func.genericParameters.thr?.let { " throws ${it.type}" } ?: ""
    val voidSuffix = if (func.returnType == "void") "V" else ""
    val throwSuffix = if (throwClause.isNotEmpty()) "X" else ""

    val template = buildString {
        if (javadoc.isNotBlank())
        {
            this.appendln("/**")
            javadoc.split('\n').forEach {
                this.appendln(" * $it")
            }
            this.appendln(" */")
        }
        if (override)
        {
            this.appendln("@Override")
        }
        annotations.filter { it.isNotEmpty() }.forEach { this.appendln(it) }
        if (body.isEmpty())
        {
            this.appendln("${func.returnType} invoke$voidSuffix$throwSuffix(${func.genericParameters.args.final(false)})$throwClause;")
        } else
        {
            this.appendln("default ${func.returnType} invoke$voidSuffix$throwSuffix(${func.genericParameters.args})$throwClause")
            this.appendln("{")
            body.forEach { this.appendln("    $it") }
            this.appendln("}")
        }
    }.toTemplate(hasOverride = override)

    return template
}

fun apply(func: FunctionDeclaration, override: Boolean = false, invokeMethod: String = "invoke"): Sequence<MemberBody>
{
    val range = 1..(func.argSize - 1)

    val regionCurrying = "// region: Currying"
    val endregionCurrying = "// endregion: Currying"

    val applyL = range.map { bindSize ->
        val bindParameters = parameters(bindSize)
        val funcRest = func.reduceL(bindSize)
            .let { it.copy(throwType = it.genericParameters.thr?.copy(extends = null)) }
        """
        /**
         * 绑定最左的${bindSize}个参数到此${func.type}上，并且返回带有剩余参数的${func.type}。
         */
        @Override
        default ${funcRest.genericType} apply($bindParameters)
        {
            return (${funcRest.genericParameters.args.mapToName()}) -> this.$invokeMethod(${func.genericParameters.args.mapToName()});
        }

        """.toTemplate(hasOverride = override)
    }

    val applyR = range.map { bindSize ->
        val bindParameters = parameters(func.argSize - bindSize + 1, func.argSize)
        val funcRest = func.reduceR(bindSize)
            .let { it.copy(throwType = it.genericParameters.thr?.copy(extends = null)) }
        """
        /**
         * 绑定最右的${bindSize}个参数到此${func.type}上，并且返回带有剩余参数的${func.type}。
         */
        @Override
        default ${funcRest.genericType} applyR($bindParameters)
        {
            return (${funcRest.genericParameters.args.mapToName()}) -> this.$invokeMethod(${func.genericParameters.args.mapToName()});
        }

        """.toTemplate(hasOverride = override)
    }
    val emptyLine = ""
    val applyLGroup = listOf(sequenceOf("// region: apply from left", emptyLine)) + applyL + listOf(sequenceOf("// endregion: apply from left", emptyLine))
    val applyRGroup = listOf(sequenceOf("// region: apply from right", emptyLine)) + applyR + listOf(sequenceOf("// endregion: apply from right"))

    val applyGroup = listOf(sequenceOf("// region: currying", emptyLine)) + (applyLGroup + applyRGroup) + listOf(sequenceOf(emptyLine, "// endregion: currying"))

    return applyGroup.asSequence().withToString()
}

fun toAction(func: FunctionDeclaration, override: Boolean = false): MemberBody
{
    val voidReturnFunc = func.copy(
        funcType = FunctionType.Action,
        throwType = func.genericParameters.thr?.copy(extends = null)
    )
    val args = func.genericParameters.args.mapToName()

    val template =
        """
        /**
         * 忽略${func.type}的返回值使其适配对应的${voidReturnFunc.type}。
         *
         * @return 参数个数相同的${voidReturnFunc.type}
         *
         * @apiNote <code><b>R</b> invoke($args)</code> &#8658; <code><b>void</b> invoke($args)</code>
         */
        @Override
        default ${voidReturnFunc.genericType} toAction()
        {
            return this::invoke;
        }
        """.toTemplate(hasOverride = override)

    return template
}

fun toFunc(func: FunctionDeclaration, override: Boolean = false): Sequence<MemberBody>
{
    val withReturnFunc = func.copy(
        funcType = FunctionType.Func,
        throwType = func.genericParameters.thr?.copy(extends = null)
    )
    val args = func.genericParameters.args.mapToName()

    //    val toFunc = """
    ///**
    // * 扩展${func.type}的返回值到{@code <R>}使其转换为对应的${withReturnFunc.type}，并使用{@code null}作为返回值。
    // *
    // * @param <R> Function返回值的类型
    // *
    // * @return 参数个数相同的${withReturnFunc.type}
    // *
    // * @apiNote <code><b>void</b> invoke($args)</code> &#8658; <code><b>R</b> invoke($args)</code>
    // */
    //@Override
    //default <R> ${withReturnFunc.genericType} toFunc()
    //{
    //    return this.toFunc(null);
    //}
    //""".toTemplate(hasOverride = override)

    val toFuncRet =
        """
        /**
         * 扩展${func.type}的返回值到{@code <R>}使其转换为对应的${withReturnFunc.type}，并使用{@code ret}作为返回值。
         *
         * @param ret 作为Function的返回值
         * @param <R> Function返回值的类型
         *
         * @return 参数个数相同的${withReturnFunc.type}
         *
         * @apiNote <code><b>void</b> invoke($args)</code> &#8658; <code><b>R</b> invoke($args)</code>
         */
        @Override
        default <R> ${withReturnFunc.genericType} toFunc(final R ret)
        {
            return ($args) ->
            {
                this.invokeV($args);
                return ret;
            };
        }
        """.toTemplate(hasOverride = override)

    return sequenceOf(/*toFunc,*/ toFuncRet).withToString()
}

fun propagate(func: FunctionDeclaration, override: Boolean = false): Sequence<MemberBody>
{
    val nothrowFunc = func.copy(javaTypeSuffix = null, throwType = null)

    val propagate =
        """
        /**
         * 将有异常声明函数转换为无异常声明的函数，函数中抛出的所有异常均被<b>原样</b>抛出。
         *
         * @return 参数个数相同但无异常声明的${nothrowFunc.type}
         *
         * @apiNote
         * 借助泛型擦除特性，虽然在实际字节码层面 {@code invoke() throws X} 声明抛出的仍是{@code X}（上界 {@link Throwable}）。<br>
         * 但在使用时将 {@code X} 强制变形为 {@link RuntimeException} ，使让编译器误认为 {@code invoke() throws RuntimeException} ，即可退化为无异常声明的 {@code invoke()} 。<br>
         * 所以，可以直接绕过编译器对{@code throws}声明的约束，将{@code ${func.rawType}::invoke}直接转换为{@code ${nothrowFunc.rawType}}。
         *
         * <p>注1：此操作不会影响运行时任何功能，也不会变更原始的异常声明，也不会吞掉任何应该抛出的异常。
         * <p>注2：性能开销上基本不会造成额外损耗，本质上是通过方法引用进行多一层的包装。
         */
        @SuppressWarnings("unchecked")
        @Override
        default ${nothrowFunc} propagate()
        {
            return (this instanceof ${nothrowFunc.rawType})
                    ? ($nothrowFunc)this
                    : ((${func.copy(throwType = GenericParameter("RuntimeException"))})this)::invoke;
        }
        """.toTemplate(hasOverride = override)

    return sequenceOf(propagate).withToString()
}

fun of(func: FunctionDeclaration): MemberBody
{
    val declFunc = func.copy(
        throwType = func.genericParameters.thr?.copy(extends = null)
    )

    val genericParameters =
        if (func.genericParameters.all.any())
        {
            "<${func.genericParameters}> "
        } else
        {
            ""
        }

    val template =
        """
        /**
         * 为lambda表达式提供简便的类型声明。
         * <p>
         * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
         * <p>
         * {@code map((${declFunc.genericType}) (${arguments(func.argSize)}) -> foo()); }
         * <p>
         * 通过此方法，可简化为：
         * <p>
         * {@code map(${declFunc.rawType}.of((${arguments(func.argSize)}) -> foo())); }
         *
         * @param f 能适配${declFunc.rawType}的lambda表达式或任意实例
         *
         * @return {@code f}自身
         */
        static $genericParameters${declFunc.genericType} of(final ${declFunc.genericType} f)
        {
            return f;
        }
        """.toTemplate()

    return template
}


internal fun String.toTemplate(hasOverride: Boolean = false): Sequence<String> =
    this.trimIndent()
        .splitToSequence('\n')
        .letIf(!hasOverride) { it.removeOverride() }
        .withToString { this.joinToString("\n") }