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
        val action = FunctionDeclaration.ActionX(i)
        val actionRef = action.copy(throwType = action.genericParameters.thr?.copy(extends = null))

        val genericParameters =
            if (action.genericParameters.all.any())
            {
                "<${action.genericParameters}> "
            } else
            {
                ""
            }

        """
        /**
         * {@link ${action.rawType}#of}的快捷方式。
         *
         * @param action ${if (action.argSize == 0) "没有" else "${action.argSize}个"}参数没有返回值的lambda表达式。
         *
         * @return {@code action}自身。
         *
         * @see ${action.rawType}#of
         */
        public static $genericParameters${actionRef.genericType} action(final ${actionRef.genericType} action)
        {
            return action;
        }
        """.toTemplate()
    }


    val funcs = (0..9).map { i ->
        val func = FunctionDeclaration.FuncX(i)
        val funcRef = func.copy(throwType = func.genericParameters.thr?.copy(extends = null))

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
         * {@link ${func.rawType}#of}的快捷方式。
         *
         * @param func ${if (func.argSize == 0) "没有" else "${func.argSize}个"}参数返回{@link R}的lambda表达式。
         *
         * @return {@code func}自身。
         *
         * @see ${func.rawType}#of
         */
        public static $genericParameters${funcRef.genericType} func(final ${funcRef.genericType} func)
        {
            return func;
        }
        """.toTemplate()
    }


    val asActions = (0..9).map { i ->
        val action = FunctionDeclaration.ActionX(i)
        val func = FunctionDeclaration.FuncX(i)
        val actionRef = action.copy(throwType = action.genericParameters.thr?.copy(extends = null))
        val funcRef = func.copy(throwType = func.genericParameters.thr?.copy(extends = null))

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
         * {@link ${func.rawType}#asAction}的快捷方式，将{@code ${func.type}}实例转换为没有返回值的{@code ${action.type}}实例。
         *
         * @param func ${if (func.argSize == 0) "没有" else "${func.argSize}个"}参数返回{@link R}的lambda表达式，或{@link ${func.rawType}}实例。
         *
         * @return {@code func}的{@code void}返回形式。
         *
         * @see ${func.rawType}#asAction
         */
        public static $genericParameters${actionRef.copy(throwType = action.genericParameters.thr?.copy(extends = null)).genericType} asAction(final ${funcRef.genericType} func)
        {
            return func.asAction();
        }
        """.toTemplate()
    }


    val toFuncNullReturns = (0..9).map { i ->
        val action = FunctionDeclaration.ActionX(i)
        val func = FunctionDeclaration.FuncX(i)
        val actionRef = action.copy(throwType = action.genericParameters.thr?.copy(extends = null))
        val funcRef = func.copy(throwType = func.genericParameters.thr?.copy(extends = null))

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
         * {@link ${action.rawType}#toFunc()}的快捷方式，将没有返回值的{@code ${action.type}}实例转换为以{@code null}为返回值的{@code ${func.type}}实例。
         *
         * @param action ${if (action.argSize == 0) "没有" else "${action.argSize}个"}参数没有返回值的lambda表达式，或{@link ${action.rawType}}实例。
         *
         * @return 返回值为{@code null}的{@code action}。
         *
         * @see ${action.rawType}#toFunc()
         */
        public static $genericParameters${funcRef.copy(throwType = func.genericParameters.thr?.copy(extends = null)).genericType} toFunc(final ${actionRef.genericType} action)
        {
            return action.toFunc();
        }
        """.toTemplate()
    }

    val toFuncs = (0..9).map { i ->
        val action = FunctionDeclaration.ActionX(i)
        val func = FunctionDeclaration.FuncX(i)
        val actionRef = action.copy(throwType = action.genericParameters.thr?.copy(extends = null))
        val funcRef = func.copy(throwType = func.genericParameters.thr?.copy(extends = null))

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
         * {@link ${action.rawType}#toFunc(R)}的快捷方式，将没有返回值的{@code ${action.type}}实例转换为以{@code returnValue}为返回值的{@code ${func.type}}实例。
         *
         * @param action      ${if (action.argSize == 0) "没有" else "${action.argSize}个"}参数没有返回值的lambda表达式，或{@link ${action.rawType}}实例。
         * @param returnValue 作为{@link ${action.rawType}}的返回值。
         *
         * @return 返回值为{@code returnValue}的{@code action}。
         *
         * @see ${action.rawType}#toFunc(R)
         */
        public static $genericParameters${funcRef.copy(throwType = func.genericParameters.thr?.copy(extends = null)).genericType} toFunc(final ${actionRef.genericType} action, final R returnValue)
        {
            return action.toFunc(returnValue);
        }
        """.toTemplate()
    }

    return (actions + funcs + asActions + toFuncNullReturns + toFuncs).asSequence()
}
