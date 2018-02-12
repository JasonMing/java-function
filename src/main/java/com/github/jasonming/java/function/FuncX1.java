/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

/**
 * 提供一个1个参数，返回值为{@link R}，声明抛出类型为{@link X}的函数式接口。
 */
@FunctionalInterface
public interface FuncX1<P1, R, X extends Throwable>
        extends Func1<P1, R>, ActionX1<P1, X>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((FuncX1<P1, R, X>) (p1) -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(FuncX1.of((p1) -> foo())); }
     *
     * @param f 能适配FuncX1的lambda表达式或任意实例
     *
     * @return {@code f}自身
     */
    static <P1, R, X extends Throwable> FuncX1<P1, R, X> of(final FuncX1<P1, R, X> f)
    {
        return f;
    }

    @Override
    @SuppressWarnings({"RedundantCast", "unchecked"})
    default R invoke(final P1 p1)
    {
        return ((FuncX1<P1, R, RuntimeException>)this).invokeX(p1);
    }

    /**
     * 执行此Func，并返回类型为{@link R}的返回值，期间可能会抛出类型为{@link X}的异常。
     */
    R invokeX(P1 p1) throws X;

    @Override
    default void invokeV(final P1 p1)
    {
        Func1.super.invokeV(p1);
    }

    @Override
    default void invokeVX(final P1 p1) throws X
    {
        this.invokeX(p1);
    }
}
