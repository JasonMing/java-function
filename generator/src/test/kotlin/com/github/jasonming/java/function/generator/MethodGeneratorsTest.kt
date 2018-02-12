/*
 * Copyright (c) 2018 JasonMing All Rights Reserved.
 */

package com.github.jasonming.java.function.generator

import org.junit.Test

/**
 * @author JasonMing
 * *
 * @version 1.0.0
 * *
 * @since 1.0.0 (2018-02-10)
 */
class MethodGeneratorsTest
{
    @Test
    fun test_invoke()
    {
        println(invoke(FunctionDeclaration.Func(3)))
        println(invoke(FunctionDeclaration.FuncE(3)))
        println(invoke(FunctionDeclaration.FuncX(3)))
        println(invoke(FunctionDeclaration.Action(3)))
        println(invoke(FunctionDeclaration.ActionE(3)))
        println(invoke(FunctionDeclaration.ActionX(3)))
    }

    @Test
    fun test_bind()
    {
        println(apply(FunctionDeclaration.FuncX(9)))
    }

    @Test
    fun test_toFunc()
    {
        println(toFunc(FunctionDeclaration.Action(3)))
    }

    @Test
    fun test_funcDef()
    {
        val func = FunctionDeclaration.ActionX(3)

        val funcDef = FunctionDefinition(func)
        funcDef.members["invoke"] = invoke(func, override = false)
        funcDef.members["apply"] = apply(func, override = false).expand()
        funcDef.members["toFunc"] = toFunc(func, override = false).expand()
        funcDef.members["propagate"] = propagate(func, override = false).expand()

        println(funcDef)
    }
}