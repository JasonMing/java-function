/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

/**
 * 提供一个7个参数，无返回值，声明抛出类型为{@link X}的函数式接口。
 */
@FunctionalInterface
public interface ActionX7<P1, P2, P3, P4, P5, P6, P7, X extends Throwable>
        extends Action7<P1, P2, P3, P4, P5, P6, P7>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((ActionX7<P1, P2, P3, P4, P5, P6, P7, X>) (p1, p2, p3, p4, p5, p6, p7) -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(ActionX7.of((p1, p2, p3, p4, p5, p6, p7) -> foo())); }
     *
     * @param f 能适配ActionX7的lambda表达式或任意实例
     *
     * @return {@code f}自身
     */
    static <P1, P2, P3, P4, P5, P6, P7, X extends Throwable> ActionX7<P1, P2, P3, P4, P5, P6, P7, X> of(final ActionX7<P1, P2, P3, P4, P5, P6, P7, X> f)
    {
        return f;
    }

    @Override
    @SuppressWarnings({"RedundantCast", "unchecked"})
    default void invokeV(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6, final P7 p7)
    {
        ((ActionX7<P1, P2, P3, P4, P5, P6, P7, RuntimeException>)this).invokeVX(p1, p2, p3, p4, p5, p6, p7);
    }

    /**
     * 执行此Action，并不返回任何值，期间可能会抛出类型为{@link X}的异常。
     */
    void invokeVX(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7) throws X;

    // region: currying


    // region: apply from left


    /**
     * 绑定最左的1个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionX6<P2, P3, P4, P5, P6, P7, X> apply(final P1 p1)
    {
        return (p2, p3, p4, p5, p6, p7) -> this.invokeV(p1, p2, p3, p4, p5, p6, p7);
    }


    /**
     * 绑定最左的2个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionX5<P3, P4, P5, P6, P7, X> apply(final P1 p1, final P2 p2)
    {
        return (p3, p4, p5, p6, p7) -> this.invokeV(p1, p2, p3, p4, p5, p6, p7);
    }


    /**
     * 绑定最左的3个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionX4<P4, P5, P6, P7, X> apply(final P1 p1, final P2 p2, final P3 p3)
    {
        return (p4, p5, p6, p7) -> this.invokeV(p1, p2, p3, p4, p5, p6, p7);
    }


    /**
     * 绑定最左的4个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionX3<P5, P6, P7, X> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4)
    {
        return (p5, p6, p7) -> this.invokeV(p1, p2, p3, p4, p5, p6, p7);
    }


    /**
     * 绑定最左的5个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionX2<P6, P7, X> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5)
    {
        return (p6, p7) -> this.invokeV(p1, p2, p3, p4, p5, p6, p7);
    }


    /**
     * 绑定最左的6个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionX1<P7, X> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6)
    {
        return (p7) -> this.invokeV(p1, p2, p3, p4, p5, p6, p7);
    }


    // endregion: apply from left


    // region: apply from right


    /**
     * 绑定最右的1个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionX6<P1, P2, P3, P4, P5, P6, X> applyR(final P7 p7)
    {
        return (p1, p2, p3, p4, p5, p6) -> this.invokeV(p1, p2, p3, p4, p5, p6, p7);
    }


    /**
     * 绑定最右的2个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionX5<P1, P2, P3, P4, P5, X> applyR(final P6 p6, final P7 p7)
    {
        return (p1, p2, p3, p4, p5) -> this.invokeV(p1, p2, p3, p4, p5, p6, p7);
    }


    /**
     * 绑定最右的3个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionX4<P1, P2, P3, P4, X> applyR(final P5 p5, final P6 p6, final P7 p7)
    {
        return (p1, p2, p3, p4) -> this.invokeV(p1, p2, p3, p4, p5, p6, p7);
    }


    /**
     * 绑定最右的4个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionX3<P1, P2, P3, X> applyR(final P4 p4, final P5 p5, final P6 p6, final P7 p7)
    {
        return (p1, p2, p3) -> this.invokeV(p1, p2, p3, p4, p5, p6, p7);
    }


    /**
     * 绑定最右的5个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionX2<P1, P2, X> applyR(final P3 p3, final P4 p4, final P5 p5, final P6 p6, final P7 p7)
    {
        return (p1, p2) -> this.invokeV(p1, p2, p3, p4, p5, p6, p7);
    }


    /**
     * 绑定最右的6个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionX1<P1, X> applyR(final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6, final P7 p7)
    {
        return (p1) -> this.invokeV(p1, p2, p3, p4, p5, p6, p7);
    }


    // endregion: apply from right


    // endregion: currying

    /**
     * 扩展Action的返回值到{@code <R>}使其转换为对应的Func，并使用{@code ret}作为返回值。
     *
     * @param ret 作为Function的返回值
     * @param <R> Function返回值的类型
     *
     * @return 参数个数相同的Func
     *
     * @apiNote <code><b>void</b> invoke(p1, p2, p3, p4, p5, p6, p7)</code> &#8658; <code><b>R</b> invoke(p1, p2, p3, p4, p5, p6, p7)</code>
     */
    @Override
    default <R> FuncX7<P1, P2, P3, P4, P5, P6, P7, R, X> toFunc(final R ret)
    {
        return (p1, p2, p3, p4, p5, p6, p7) ->
        {
            this.invokeV(p1, p2, p3, p4, p5, p6, p7);
            return ret;
        };
    }
}
