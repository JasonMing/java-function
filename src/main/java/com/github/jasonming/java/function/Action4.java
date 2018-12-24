/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

/**
 * 提供一个4个参数，无返回值，无异常抛出声明的函数式接口。
 */
@FunctionalInterface
public interface Action4<P1, P2, P3, P4>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((Action4<P1, P2, P3, P4>) (p1, p2, p3, p4) -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(Action4.of((p1, p2, p3, p4) -> foo())); }
     *
     * @param f 能适配Action4的lambda表达式或任意实例。
     *
     * @return {@code f}自身。
     */
    static <P1, P2, P3, P4> Action4<P1, P2, P3, P4> of(final Action4<P1, P2, P3, P4> f)
    {
        return f;
    }

    /**
     * 扩展Action的返回值到{@code <R>}使其转换为对应的Func，并使用{@code null}作为返回值。
     *
     * @param <R> Function返回值的类型。
     *
     * @return 参数个数相同的Func。
     *
     * @apiNote <code><b>void</b> invoke(p1, p2, p3, p4)</code> &#8658; <code><b>R</b> invoke(p1, p2, p3, p4)</code>
     */
    default <R> Func4<P1, P2, P3, P4, R> toFunc()
    {
        return this.toFunc(null);
    }

    /**
     * 扩展Action的返回值到{@code <R>}使其转换为对应的Func，并使用{@code returnValue}作为返回值。
     *
     * @param returnValue 作为Function的返回值。
     * @param <R>         Function返回值的类型。
     *
     * @return 参数个数相同的Func。
     *
     * @apiNote <code><b>void</b> invoke(p1, p2, p3, p4)</code> &#8658; <code><b>R</b> invoke(p1, p2, p3, p4)</code>
     */
    default <R> Func4<P1, P2, P3, P4, R> toFunc(final R returnValue)
    {
        return (p1, p2, p3, p4) ->
        {
            this.invokeV(p1, p2, p3, p4);
            return returnValue;
        };
    }

    /**
     * 执行此Action，并不返回任何值。
     */
    void invokeV(P1 p1, P2 p2, P3 p3, P4 p4);

    // region: currying

    // region: apply from left

    /**
     * 绑定最左的1个参数到此Action上，并且返回带有剩余参数的Action。
     */
    default Action3<P2, P3, P4> apply(final P1 p1)
    {
        return (p2, p3, p4) -> this.invokeV(p1, p2, p3, p4);
    }

    /**
     * 绑定最左的2个参数到此Action上，并且返回带有剩余参数的Action。
     */
    default Action2<P3, P4> apply(final P1 p1, final P2 p2)
    {
        return (p3, p4) -> this.invokeV(p1, p2, p3, p4);
    }

    /**
     * 绑定最左的3个参数到此Action上，并且返回带有剩余参数的Action。
     */
    default Action1<P4> apply(final P1 p1, final P2 p2, final P3 p3)
    {
        return (p4) -> this.invokeV(p1, p2, p3, p4);
    }

    // endregion: apply from left

    // region: apply from right

    /**
     * 绑定最右的1个参数到此Action上，并且返回带有剩余参数的Action。
     */
    default Action3<P1, P2, P3> applyR(final P4 p4)
    {
        return (p1, p2, p3) -> this.invokeV(p1, p2, p3, p4);
    }

    /**
     * 绑定最右的2个参数到此Action上，并且返回带有剩余参数的Action。
     */
    default Action2<P1, P2> applyR(final P3 p3, final P4 p4)
    {
        return (p1, p2) -> this.invokeV(p1, p2, p3, p4);
    }

    /**
     * 绑定最右的3个参数到此Action上，并且返回带有剩余参数的Action。
     */
    default Action1<P1> applyR(final P2 p2, final P3 p3, final P4 p4)
    {
        return (p1) -> this.invokeV(p1, p2, p3, p4);
    }

    // endregion: apply from right

    // endregion: currying
}
