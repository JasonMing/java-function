/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

/**
 * 提供一个3个参数，返回值为{@link R}，声明抛出类型为{@link X}的函数式接口。
 */
@FunctionalInterface
public interface FuncX3<P1, P2, P3, R, X extends Throwable>
        extends Func3<P1, P2, P3, R>, ActionX3<P1, P2, P3, X>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((FuncX3<P1, P2, P3, R, X>) (p1, p2, p3) -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(FuncX3.of((p1, p2, p3) -> foo())); }
     *
     * @param f 能适配FuncX3的lambda表达式或任意实例
     *
     * @return {@code f}自身
     */
    static <P1, P2, P3, R, X extends Throwable> FuncX3<P1, P2, P3, R, X> of(final FuncX3<P1, P2, P3, R, X> f)
    {
        return f;
    }

    @Override
    @SuppressWarnings({"RedundantCast", "unchecked"})
    default R invoke(final P1 p1, final P2 p2, final P3 p3)
    {
        return ((FuncX3<P1, P2, P3, R, RuntimeException>)this).invokeX(p1, p2, p3);
    }

    /**
     * 执行此Func，并返回类型为{@link R}的返回值，期间可能会抛出类型为{@link X}的异常。
     */
    R invokeX(P1 p1, P2 p2, P3 p3) throws X;

    @Override
    default void invokeV(final P1 p1, final P2 p2, final P3 p3)
    {
        Func3.super.invokeV(p1, p2, p3);
    }

    @Override
    default void invokeVX(final P1 p1, final P2 p2, final P3 p3) throws X
    {
        this.invokeX(p1, p2, p3);
    }

    // region: currying

    // region: apply from left

    /**
     * 绑定最左的1个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX2<P2, P3, R, X> apply(final P1 p1)
    {
        return (p2, p3) -> this.invoke(p1, p2, p3);
    }

    /**
     * 绑定最左的2个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX1<P3, R, X> apply(final P1 p1, final P2 p2)
    {
        return (p3) -> this.invoke(p1, p2, p3);
    }

    // endregion: apply from left

    // region: apply from right

    /**
     * 绑定最右的1个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX2<P1, P2, R, X> applyR(final P3 p3)
    {
        return (p1, p2) -> this.invoke(p1, p2, p3);
    }

    /**
     * 绑定最右的2个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX1<P1, R, X> applyR(final P2 p2, final P3 p3)
    {
        return (p1) -> this.invoke(p1, p2, p3);
    }

    // endregion: apply from right

    // endregion: currying
}
