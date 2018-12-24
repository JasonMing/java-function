/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

import java.util.function.Supplier;


/**
 * 提供一个无参数，返回值为{@link R}，无异常抛出声明的函数式接口。
 */
@FunctionalInterface
public interface Func<R>
        extends Supplier<R>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((Func<R>) () -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(Func.of(() -> foo())); }
     *
     * @param f 能适配Func的lambda表达式或任意实例。
     *
     * @return {@code f}自身。
     */
    static <R> Func<R> of(final Func<R> f)
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
    default Action asAction()
    {
        return this::invoke;
    }

    /**
     * 执行此Func，并返回类型为{@link R}的返回值。
     */
    R invoke();

    @Override
    default R get()
    {
        return this.invoke();
    }
}
