/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

import java.util.concurrent.Callable;


/**
 * 提供一个无参数，返回值为{@link R}，声明抛出类型为{@link Exception}的函数式接口。
 */
@FunctionalInterface
public interface FuncE<R>
        extends FuncX<R, Exception>, Callable<R>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((FuncE<R>) () -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(FuncE.of(() -> foo())); }
     *
     * @param f 能适配FuncE的lambda表达式或任意实例。
     *
     * @return {@code f}自身。
     */
    static <R> FuncE<R> of(final FuncE<R> f)
    {
        return f;
    }

    /**
     * 忽略Func的返回值使其适配对应的Action。
     *
     * @return 参数个数相同的Action。
     *
     * @apiNote <code><b>R</b> invoke()</code> &#8658; <code><b>void</b> invoke()</code>
     */
    @Override
    default ActionE asAction()
    {
        return this::invoke;
    }

    @Override
    default R call() throws Exception
    {
        return this.invoke();
    }
}
