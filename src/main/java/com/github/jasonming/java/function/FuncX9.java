/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

/**
 * 提供一个9个参数，返回值为{@link R}，声明抛出类型为{@link X}的函数式接口。
 */
@FunctionalInterface
public interface FuncX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R, X extends Throwable>
        extends Func9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R>, ActionX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, X>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((FuncX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R, X>) (p1, p2, p3, p4, p5, p6, p7, p8, p9) -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(FuncX9.of((p1, p2, p3, p4, p5, p6, p7, p8, p9) -> foo())); }
     *
     * @param f 能适配FuncX9的lambda表达式或任意实例
     *
     * @return {@code f}自身
     */
    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, R, X extends Throwable> FuncX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R, X> of(final FuncX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R, X> f)
    {
        return f;
    }

    @Override
    @SuppressWarnings({"RedundantCast", "unchecked"})
    default R invoke(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6, final P7 p7, final P8 p8, final P9 p9)
    {
        return ((FuncX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R, RuntimeException>)this).invokeX(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 执行此Func，并返回类型为{@link R}的返回值，期间可能会抛出类型为{@link X}的异常。
     */
    R invokeX(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9) throws X;

    @Override
    default void invokeV(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6, final P7 p7, final P8 p8, final P9 p9)
    {
        Func9.super.invokeV(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    @Override
    default void invokeVX(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6, final P7 p7, final P8 p8, final P9 p9) throws X
    {
        this.invokeX(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    // region: currying

    // region: apply from left

    /**
     * 绑定最左的1个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX8<P2, P3, P4, P5, P6, P7, P8, P9, R, X> apply(final P1 p1)
    {
        return (p2, p3, p4, p5, p6, p7, p8, p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最左的2个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX7<P3, P4, P5, P6, P7, P8, P9, R, X> apply(final P1 p1, final P2 p2)
    {
        return (p3, p4, p5, p6, p7, p8, p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最左的3个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX6<P4, P5, P6, P7, P8, P9, R, X> apply(final P1 p1, final P2 p2, final P3 p3)
    {
        return (p4, p5, p6, p7, p8, p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最左的4个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX5<P5, P6, P7, P8, P9, R, X> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4)
    {
        return (p5, p6, p7, p8, p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最左的5个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX4<P6, P7, P8, P9, R, X> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5)
    {
        return (p6, p7, p8, p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最左的6个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX3<P7, P8, P9, R, X> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6)
    {
        return (p7, p8, p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最左的7个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX2<P8, P9, R, X> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6, final P7 p7)
    {
        return (p8, p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最左的8个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX1<P9, R, X> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6, final P7 p7, final P8 p8)
    {
        return (p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    // endregion: apply from left

    // region: apply from right

    /**
     * 绑定最右的1个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX8<P1, P2, P3, P4, P5, P6, P7, P8, R, X> applyR(final P9 p9)
    {
        return (p1, p2, p3, p4, p5, p6, p7, p8) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最右的2个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX7<P1, P2, P3, P4, P5, P6, P7, R, X> applyR(final P8 p8, final P9 p9)
    {
        return (p1, p2, p3, p4, p5, p6, p7) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最右的3个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX6<P1, P2, P3, P4, P5, P6, R, X> applyR(final P7 p7, final P8 p8, final P9 p9)
    {
        return (p1, p2, p3, p4, p5, p6) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最右的4个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX5<P1, P2, P3, P4, P5, R, X> applyR(final P6 p6, final P7 p7, final P8 p8, final P9 p9)
    {
        return (p1, p2, p3, p4, p5) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最右的5个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX4<P1, P2, P3, P4, R, X> applyR(final P5 p5, final P6 p6, final P7 p7, final P8 p8, final P9 p9)
    {
        return (p1, p2, p3, p4) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最右的6个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX3<P1, P2, P3, R, X> applyR(final P4 p4, final P5 p5, final P6 p6, final P7 p7, final P8 p8, final P9 p9)
    {
        return (p1, p2, p3) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最右的7个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX2<P1, P2, R, X> applyR(final P3 p3, final P4 p4, final P5 p5, final P6 p6, final P7 p7, final P8 p8, final P9 p9)
    {
        return (p1, p2) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最右的8个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncX1<P1, R, X> applyR(final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6, final P7 p7, final P8 p8, final P9 p9)
    {
        return (p1) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    // endregion: apply from right

    // endregion: currying
}