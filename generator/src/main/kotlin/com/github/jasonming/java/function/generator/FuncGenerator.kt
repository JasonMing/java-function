/*
 * Copyright (c) 2018 JasonMing All Rights Reserved.
 */

package com.github.jasonming.java.function.generator

fun generateFunctions(): Map<String /* File */, String /* Content */>
{
    val result = LinkedHashMap<String, String>()

    result += ::defFunc.generateAll()
        .applyOn(0)
        {
            this.imports += "java.util.function.Supplier"
            this.extends += "Supplier<R>"
            this.members["JDK adapter"] = """
@Override
default R get()
{
    return this.invoke();
}
""".toTemplate(hasOverride = true)
        }
        .applyOn(1)
        {
            this.imports += "java.util.function.Function"
            this.extends += "Function<P1, R>"
            this.members["JDK adapter"] = """
@Override
default R apply(final P1 p1)
{
    return this.invoke(p1);
}
""".toTemplate(hasOverride = true)
        }
        .applyOn(2)
        {
            this.imports += "java.util.function.BiFunction"
            this.extends += "BiFunction<P1, P2, R>"
            this.members["JDK adapter"] = """
@Override
default R apply(final P1 p1, final P2 p2)
{
    return this.invoke(p1, p2);
}
""".toTemplate(hasOverride = true)
        }
        .toMap()

    result += ::defFuncE.generateAll()
        .applyOn(0) {
            this.imports += "java.util.concurrent.Callable"
            this.extends += "Callable<R>"
            this.members["JDK adapter"] = """
@Override
default R call() throws Exception
{
    return this.invoke();
}
""".toTemplate(hasOverride = true)
        }
        .toMap()

    result += ::defFuncX.generateAll()
        .toMap()

    return result
}

private fun defFunc(x: Int): FunctionDefinition
{
    val func = FunctionDeclaration.Func(x)
    val baseFunc = FunctionDeclaration.Action(x)

    val args = func.genericParameters.args.mapToName()

    val funcDef = FunctionDefinition(func, baseFunc).apply {
        javadoc = "提供一个${if (func.argSize > 0) "${func.argSize}个" else "无"}参数，返回值为{@link R}，无异常抛出声明的函数式接口。"
        members["of"] = of(func)
        members["invoke"] = invoke(func,
            javadoc = "执行此${func.type}，并返回类型为{@link R}的返回值。")
        members["invokeV"] = invoke(baseFunc,
            override = true,
            body = "this.invoke($args);")
        members["apply"] = apply(func, override = true).flatten()
    }

    return funcDef
}

private fun defFuncX(x: Int): FunctionDefinition
{
    val func = FunctionDeclaration.FuncX(x)
    val baseFunc = FunctionDeclaration.Func(x)
    val rootFunc = FunctionDeclaration.Action(x)
    val linkFunc = FunctionDeclaration.ActionX(x)

    val args = func.genericParameters.args.mapToName()

    val funcDef = FunctionDefinition(func, baseFunc).apply {
        javadoc = "提供一个${if (func.argSize > 0) "${func.argSize}个" else "无"}参数，返回值为{@link R}，声明抛出类型为{@link X}的函数式接口。"
        extends.add(linkFunc.copy(
            throwType = linkFunc.genericParameters.thr?.copy(extends = null)).genericType)
        members["of"] = of(func)
        members["invoke"] = invoke(baseFunc,
            override = true,
            annotations = arrayOf("@SuppressWarnings({\"RedundantCast\", \"unchecked\"})"),
            body = "return ((${func.copy(throwType = func.genericParameters.thr!!.copy("RuntimeException", null)).genericType})this).invokeX($args);")
        members["invokeX"] = invoke(func,
            javadoc = "执行此${func.type}，并返回类型为{@link R}的返回值，期间可能会抛出类型为{@link X}的异常。")
        members["invokeV"] = invoke(rootFunc,
            override = true,
            body = "${baseFunc.rawType}.super.invokeV($args);")
        members["invokeVX"] = invoke(linkFunc,
            override = true,
            body = "this.invokeX($args);")
        members["apply"] = apply(func, override = true).flatten()
    }

    return funcDef
}

private fun defFuncE(x: Int): FunctionDefinition
{
    val func = FunctionDeclaration.FuncE(x)
    val baseFunc = FunctionDeclaration.FuncX(x).copy(throwType = GenericParameter("Exception"))
    val linkFunc = FunctionDeclaration.ActionE(x)

    val funcDef = FunctionDefinition(func, baseFunc).apply {
        javadoc = "提供一个${if (func.argSize > 0) "${func.argSize}个" else "无"}参数，返回值为{@link R}，声明抛出类型为{@link Exception}的函数式接口。"
        extends.add(linkFunc.genericType)
        members["of"] = of(func)
        members["apply"] = apply(func, override = true).flatten()
    }

    return funcDef
}
