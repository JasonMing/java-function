/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

import java.util.function.Function;


/**
 * 提供一个1个参数，返回值为{@link R}，无异常抛出声明的函数式接口。
 */
@FunctionalInterface
public interface Func1<P1, R>
        extends Action1<P1>, Function<P1, R>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((Func1<P1, R>) (p1) -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(Func1.of((p1) -> foo())); }
     *
     * @param f 能适配Func1的lambda表达式或任意实例
     *
     * @return {@code f}自身
     */
    static <P1, R> Func1<P1, R> of(final Func1<P1, R> f)
    {
        return f;
    }

    /**
     * 执行此Func，并返回类型为{@link R}的返回值。
     */
    R invoke(P1 p1);

    @Override
    default void invokeV(final P1 p1)
    {
        this.invoke(p1);
    }

    @Override
    default R apply(final P1 p1)
    {
        return this.invoke(p1);
    }
}
