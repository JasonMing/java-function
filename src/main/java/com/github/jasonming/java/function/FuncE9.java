/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

/**
 * 提供一个9个参数，返回值为{@link R}，声明抛出类型为{@link Exception}的函数式接口。
 */
@FunctionalInterface
public interface FuncE9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R>
        extends FuncX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R, Exception>, ActionE9<P1, P2, P3, P4, P5, P6, P7, P8, P9>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((FuncE9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R>) (p1, p2, p3, p4, p5, p6, p7, p8, p9) -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(FuncE9.of((p1, p2, p3, p4, p5, p6, p7, p8, p9) -> foo())); }
     *
     * @param f 能适配FuncE9的lambda表达式或任意实例
     *
     * @return {@code f}自身
     */
    static <P1, P2, P3, P4, P5, P6, P7, P8, P9, R> FuncE9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> of(final FuncE9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> f)
    {
        return f;
    }

    // region: currying

    // region: apply from left

    /**
     * 绑定最左的1个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE8<P2, P3, P4, P5, P6, P7, P8, P9, R> apply(final P1 p1)
    {
        return (p2, p3, p4, p5, p6, p7, p8, p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最左的2个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE7<P3, P4, P5, P6, P7, P8, P9, R> apply(final P1 p1, final P2 p2)
    {
        return (p3, p4, p5, p6, p7, p8, p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最左的3个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE6<P4, P5, P6, P7, P8, P9, R> apply(final P1 p1, final P2 p2, final P3 p3)
    {
        return (p4, p5, p6, p7, p8, p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最左的4个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE5<P5, P6, P7, P8, P9, R> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4)
    {
        return (p5, p6, p7, p8, p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最左的5个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE4<P6, P7, P8, P9, R> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5)
    {
        return (p6, p7, p8, p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最左的6个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE3<P7, P8, P9, R> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6)
    {
        return (p7, p8, p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最左的7个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE2<P8, P9, R> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6, final P7 p7)
    {
        return (p8, p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最左的8个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE1<P9, R> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6, final P7 p7, final P8 p8)
    {
        return (p9) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    // endregion: apply from left

    // region: apply from right

    /**
     * 绑定最右的1个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE8<P1, P2, P3, P4, P5, P6, P7, P8, R> applyR(final P9 p9)
    {
        return (p1, p2, p3, p4, p5, p6, p7, p8) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最右的2个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE7<P1, P2, P3, P4, P5, P6, P7, R> applyR(final P8 p8, final P9 p9)
    {
        return (p1, p2, p3, p4, p5, p6, p7) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最右的3个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE6<P1, P2, P3, P4, P5, P6, R> applyR(final P7 p7, final P8 p8, final P9 p9)
    {
        return (p1, p2, p3, p4, p5, p6) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最右的4个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE5<P1, P2, P3, P4, P5, R> applyR(final P6 p6, final P7 p7, final P8 p8, final P9 p9)
    {
        return (p1, p2, p3, p4, p5) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最右的5个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE4<P1, P2, P3, P4, R> applyR(final P5 p5, final P6 p6, final P7 p7, final P8 p8, final P9 p9)
    {
        return (p1, p2, p3, p4) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最右的6个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE3<P1, P2, P3, R> applyR(final P4 p4, final P5 p5, final P6 p6, final P7 p7, final P8 p8, final P9 p9)
    {
        return (p1, p2, p3) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最右的7个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE2<P1, P2, R> applyR(final P3 p3, final P4 p4, final P5 p5, final P6 p6, final P7 p7, final P8 p8, final P9 p9)
    {
        return (p1, p2) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    /**
     * 绑定最右的8个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE1<P1, R> applyR(final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6, final P7 p7, final P8 p8, final P9 p9)
    {
        return (p1) -> this.invoke(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    // endregion: apply from right

    // endregion: currying
}
