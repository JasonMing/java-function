/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

/**
 * 提供一个6个参数，无返回值，声明抛出类型为{@link Exception}的函数式接口。
 */
@FunctionalInterface
public interface ActionE6<P1, P2, P3, P4, P5, P6>
        extends ActionX6<P1, P2, P3, P4, P5, P6, Exception>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((ActionE6<P1, P2, P3, P4, P5, P6>) (p1, p2, p3, p4, p5, p6) -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(ActionE6.of((p1, p2, p3, p4, p5, p6) -> foo())); }
     *
     * @param f 能适配ActionE6的lambda表达式或任意实例
     *
     * @return {@code f}自身
     */
    static <P1, P2, P3, P4, P5, P6> ActionE6<P1, P2, P3, P4, P5, P6> of(final ActionE6<P1, P2, P3, P4, P5, P6> f)
    {
        return f;
    }

    // region: currying


    // region: apply from left


    /**
     * 绑定最左的1个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionE5<P2, P3, P4, P5, P6> apply(final P1 p1)
    {
        return (p2, p3, p4, p5, p6) -> this.invokeV(p1, p2, p3, p4, p5, p6);
    }


    /**
     * 绑定最左的2个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionE4<P3, P4, P5, P6> apply(final P1 p1, final P2 p2)
    {
        return (p3, p4, p5, p6) -> this.invokeV(p1, p2, p3, p4, p5, p6);
    }


    /**
     * 绑定最左的3个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionE3<P4, P5, P6> apply(final P1 p1, final P2 p2, final P3 p3)
    {
        return (p4, p5, p6) -> this.invokeV(p1, p2, p3, p4, p5, p6);
    }


    /**
     * 绑定最左的4个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionE2<P5, P6> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4)
    {
        return (p5, p6) -> this.invokeV(p1, p2, p3, p4, p5, p6);
    }


    /**
     * 绑定最左的5个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionE1<P6> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5)
    {
        return (p6) -> this.invokeV(p1, p2, p3, p4, p5, p6);
    }


    // endregion: apply from left


    // region: apply from right


    /**
     * 绑定最右的1个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionE5<P1, P2, P3, P4, P5> applyR(final P6 p6)
    {
        return (p1, p2, p3, p4, p5) -> this.invokeV(p1, p2, p3, p4, p5, p6);
    }


    /**
     * 绑定最右的2个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionE4<P1, P2, P3, P4> applyR(final P5 p5, final P6 p6)
    {
        return (p1, p2, p3, p4) -> this.invokeV(p1, p2, p3, p4, p5, p6);
    }


    /**
     * 绑定最右的3个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionE3<P1, P2, P3> applyR(final P4 p4, final P5 p5, final P6 p6)
    {
        return (p1, p2, p3) -> this.invokeV(p1, p2, p3, p4, p5, p6);
    }


    /**
     * 绑定最右的4个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionE2<P1, P2> applyR(final P3 p3, final P4 p4, final P5 p5, final P6 p6)
    {
        return (p1, p2) -> this.invokeV(p1, p2, p3, p4, p5, p6);
    }


    /**
     * 绑定最右的5个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionE1<P1> applyR(final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6)
    {
        return (p1) -> this.invokeV(p1, p2, p3, p4, p5, p6);
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
     * @apiNote <code><b>void</b> invoke(p1, p2, p3, p4, p5, p6)</code> &#8658; <code><b>R</b> invoke(p1, p2, p3, p4, p5, p6)</code>
     */
    @Override
    default <R> FuncE6<P1, P2, P3, P4, P5, P6, R> toFunc(final R ret)
    {
        return (p1, p2, p3, p4, p5, p6) ->
        {
            this.invokeV(p1, p2, p3, p4, p5, p6);
            return ret;
        };
    }
}
