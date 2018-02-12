/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

import java.util.function.BiFunction;


/**
 * 提供一个2个参数，返回值为{@link R}，无异常抛出声明的函数式接口。
 */
@FunctionalInterface
public interface Func2<P1, P2, R>
        extends Action2<P1, P2>, BiFunction<P1, P2, R>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((Func2<P1, P2, R>) (p1, p2) -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(Func2.of((p1, p2) -> foo())); }
     *
     * @param f 能适配Func2的lambda表达式或任意实例
     *
     * @return {@code f}自身
     */
    static <P1, P2, R> Func2<P1, P2, R> of(final Func2<P1, P2, R> f)
    {
        return f;
    }

    /**
     * 执行此Func，并返回类型为{@link R}的返回值。
     */
    R invoke(P1 p1, P2 p2);

    @Override
    default void invokeV(final P1 p1, final P2 p2)
    {
        this.invoke(p1, p2);
    }

    // region: currying

    // region: apply from left

    /**
     * 绑定最左的1个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default Func1<P2, R> apply(final P1 p1)
    {
        return (p2) -> this.invoke(p1, p2);
    }

    // endregion: apply from left

    // region: apply from right

    /**
     * 绑定最右的1个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default Func1<P1, R> applyR(final P2 p2)
    {
        return (p1) -> this.invoke(p1, p2);
    }

    // endregion: apply from right

    // endregion: currying

    @Override
    default R apply(final P1 p1, final P2 p2)
    {
        return this.invoke(p1, p2);
    }
}
