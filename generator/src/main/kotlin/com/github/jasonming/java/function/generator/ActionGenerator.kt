/*
 * Copyright (c) 2018 JasonMing All Rights Reserved.
 */

package com.github.jasonming.java.function.generator

fun generateActions(): Map<String /* File */, String /* Content */>
{
    val result = LinkedHashMap<String, String>()

    result += ::defAction.generateAll()
        .applyOn(0)
        {
            this.extends += "Runnable"
            this.members["JDK adapter"] =
                """
                @Override
                default void run()
                {
                    this.invokeV();
                }
                """.toTemplate(hasOverride = true)
        }
        .applyOn(1)
        {
            this.imports += "java.util.function.Consumer"
            this.extends += "Consumer<P1>"
            this.members["JDK adapter"] =
                """
                @Override
                default void accept(final P1 p1)
                {
                    this.invokeV(p1);
                }
                """.toTemplate(hasOverride = true)
        }
        .applyOn(2)
        {
            this.imports += "java.util.function.BiConsumer"
            this.extends += "BiConsumer<P1, P2>"
            this.members["JDK adapter"] =
                """
                @Override
                default void accept(final P1 p1, final P2 p2)
                {
                    this.invokeV(p1, p2);
                }
                """.toTemplate(hasOverride = true)
        }
        .toMap()

    result += ::defActionX.generateAll()
        .toMap()

    result += ::defActionE.generateAll()
        .toMap()

    return result
}

private fun defAction(x: Int): FunctionDefinition
{
    val func = FunctionDeclaration.Action(x)
   // val baseFunc = FunctionDeclaration.Func(x).copy(overrideReturnType = "Void")

    val args = func.genericParameters.args.mapToName()

    val funcDef = FunctionDefinition(func).apply {
        javadoc = "提供一个${if (func.argSize > 0) "${func.argSize}个" else "无"}参数，无返回值，无异常抛出声明的函数式接口。"
        members["of"] = of(func)
        members["toFunc"] = toFunc(func, override = false).expand()
        // members["invoke"] = invoke(baseFunc, override = true, body = *arrayOf("this.invokeV($args);", "return null;"))
        members["invokeV"] = invoke(func, javadoc = "执行此${func.type}，并不返回任何值。")
        members["apply"] = apply(func, override = false, invokeMethod = "invokeV").expand()
    }

    return funcDef
}

private fun defActionX(x: Int): FunctionDefinition
{
    val func = FunctionDeclaration.ActionX(x)
    val baseFunc = FunctionDeclaration.Action(x)
    // val rootFunc = FunctionDeclaration.Func(x).copy(overrideReturnType = "Void")
    // val linkFunc = FunctionDeclaration.FuncX(x).copy(overrideReturnType = "Void")

    val args = func.genericParameters.args.mapToName()

    val funcDef = FunctionDefinition(func, baseFunc).apply {
        javadoc = "提供一个${if (func.argSize > 0) "${func.argSize}个" else "无"}参数，无返回值，声明抛出类型为{@link X}的函数式接口。"
        // extends.add(linkFunc.copy(throwType = linkFunc.genericParameters.thr?.copy(extends = null)).genericType)
        members["of"] = of(func)
        members["toFunc"] = toFunc(func, override = true).expand()
        // members["invoke"] = invoke(rootFunc, override = true, body = "return ${baseFunc.rawType}.super.invoke($args);")
        // members["invokeX"] = invoke(linkFunc, override = true, body = *arrayOf("this.invokeVX($args);", "return null;"))
        members["invokeV"] = invoke(baseFunc,
            override = true,
            annotations = arrayOf("@SuppressWarnings({\"RedundantCast\", \"unchecked\"})"),
            body = *arrayOf("((${func.copy(throwType = func.genericParameters.thr!!.copy("RuntimeException", null)).genericType})this).invokeVX($args);"))
        members["invokeVX"] = invoke(func, javadoc = "执行此${func.type}，并不返回任何值，期间可能会抛出类型为{@link X}的异常。")
        members["apply"] = apply(func, override = true, invokeMethod = "invokeV").expand()
    }

    return funcDef
}

private fun defActionE(x: Int): FunctionDefinition
{
    val func = FunctionDeclaration.ActionE(x)
    val baseFunc = FunctionDeclaration.ActionX(x).copy(throwType = GenericParameter("Exception"))
    // val linkFunc = FunctionDeclaration.FuncE(x).copy(overrideReturnType = "Void")

    val funcDef = FunctionDefinition(func, baseFunc).apply {
        javadoc = "提供一个${if (func.argSize > 0) "${func.argSize}个" else "无"}参数，无返回值，声明抛出类型为{@link Exception}的函数式接口。"
        // extends.add(linkFunc.genericType)
        members["of"] = of(func)
        members["apply"] = apply(func, override = true, invokeMethod = "invokeV").expand()
        members["toFunc"] = toFunc(func, override = true).expand()
    }

    return funcDef
}
