/*
 * Copyright (c) 2018 JasonMing All Rights Reserved.
 */

package com.github.jasonming.java.function.generator


fun main(args: Array<String>)
{
    println(generateOf().joinToString("\n\n"))
}
fun generateFunctionsClass(): ClassBody
{
    TODO()
}

private fun generateOf(): Sequence<MemberBody>
{
    val actions = (0..9).map { i ->
        val func = FunctionDeclaration.Action(i)
        val funcX = FunctionDeclaration.ActionX(i)

        val genericParameters =
            if (func.genericParameters.all.any())
            {
                "<${func.genericParameters}> "
            } else
            {
                ""
            }

        """
        /**
         * {@link ${func.rawType}#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link ${funcX.rawType}#of}。
         *
         * @param f 能适配${func.rawType}的lambda表达式或任意实例
         *
         * @return {@code f}自身
         *
         * @see ${func.rawType}#of
         */
        public static $genericParameters${func.genericType} of(final ${func.genericType} f)
        {
            return f;
        }
        """.toTemplate()
    }


    val funcs = (0..9).map { i ->
        val func = FunctionDeclaration.Func(i)
        val funcX = FunctionDeclaration.FuncX(i)

        val genericParameters =
            if (func.genericParameters.all.any())
            {
                "<${func.genericParameters}> "
            } else
            {
                ""
            }

        """
        /**
         * {@link ${func.rawType}#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link ${funcX.rawType}#of}。
         *
         * @param f 能适配${func.rawType}的lambda表达式或任意实例
         *
         * @return {@code f}自身
         *
         * @see ${func.rawType}#of
         */
        public static $genericParameters${func.genericType} of(final ${func.genericType} f)
        {
            return f;
        }
        """.toTemplate()
    }

    return (actions + funcs).asSequence()
}
