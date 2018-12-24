/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

/**
 * 提供一个6个参数，返回值为{@link R}，无异常抛出声明的函数式接口。
 */
@FunctionalInterface
public interface Func6<P1, P2, P3, P4, P5, P6, R>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((Func6<P1, P2, P3, P4, P5, P6, R>) (p1, p2, p3, p4, p5, p6) -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(Func6.of((p1, p2, p3, p4, p5, p6) -> foo())); }
     *
     * @param f 能适配Func6的lambda表达式或任意实例。
     *
     * @return {@code f}自身。
     */
    static <P1, P2, P3, P4, P5, P6, R> Func6<P1, P2, P3, P4, P5, P6, R> of(final Func6<P1, P2, P3, P4, P5, P6, R> f)
    {
        return f;
    }

    /**
     * 忽略Func的返回值使其适配对应的Action。
     *
     * @return 参数个数相同的Action。
     *
     * @apiNote <code><b>R</b> invoke(p1, p2, p3, p4, p5, p6)</code> &#8658; <code><b>void</b> invoke(p1, p2, p3, p4, p5, p6)</code>
     */
    default Action6<P1, P2, P3, P4, P5, P6> asAction()
    {
        return this::invoke;
    }

    /**
     * 执行此Func，并返回类型为{@link R}的返回值。
     */
    R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6);

    // region: currying
    // region: apply from left
    /**
     * 绑定最左的1个参数到此Func上，并且返回带有剩余参数的Func。
     */
    default Func5<P2, P3, P4, P5, P6, R> apply(final P1 p1)
    {
        return (p2, p3, p4, p5, p6) -> this.invoke(p1, p2, p3, p4, p5, p6);
    }
    /**
     * 绑定最左的2个参数到此Func上，并且返回带有剩余参数的Func。
     */
    default Func4<P3, P4, P5, P6, R> apply(final P1 p1, final P2 p2)
    {
        return (p3, p4, p5, p6) -> this.invoke(p1, p2, p3, p4, p5, p6);
    }
    /**
     * 绑定最左的3个参数到此Func上，并且返回带有剩余参数的Func。
     */
    default Func3<P4, P5, P6, R> apply(final P1 p1, final P2 p2, final P3 p3)
    {
        return (p4, p5, p6) -> this.invoke(p1, p2, p3, p4, p5, p6);
    }
    /**
     * 绑定最左的4个参数到此Func上，并且返回带有剩余参数的Func。
     */
    default Func2<P5, P6, R> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4)
    {
        return (p5, p6) -> this.invoke(p1, p2, p3, p4, p5, p6);
    }
    /**
     * 绑定最左的5个参数到此Func上，并且返回带有剩余参数的Func。
     */
    default Func1<P6, R> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5)
    {
        return (p6) -> this.invoke(p1, p2, p3, p4, p5, p6);
    }
    // endregion: apply from left
    // region: apply from right
    /**
     * 绑定最右的1个参数到此Func上，并且返回带有剩余参数的Func。
     */
    default Func5<P1, P2, P3, P4, P5, R> applyR(final P6 p6)
    {
        return (p1, p2, p3, p4, p5) -> this.invoke(p1, p2, p3, p4, p5, p6);
    }
    /**
     * 绑定最右的2个参数到此Func上，并且返回带有剩余参数的Func。
     */
    default Func4<P1, P2, P3, P4, R> applyR(final P5 p5, final P6 p6)
    {
        return (p1, p2, p3, p4) -> this.invoke(p1, p2, p3, p4, p5, p6);
    }
    /**
     * 绑定最右的3个参数到此Func上，并且返回带有剩余参数的Func。
     */
    default Func3<P1, P2, P3, R> applyR(final P4 p4, final P5 p5, final P6 p6)
    {
        return (p1, p2, p3) -> this.invoke(p1, p2, p3, p4, p5, p6);
    }
    /**
     * 绑定最右的4个参数到此Func上，并且返回带有剩余参数的Func。
     */
    default Func2<P1, P2, R> applyR(final P3 p3, final P4 p4, final P5 p5, final P6 p6)
    {
        return (p1, p2) -> this.invoke(p1, p2, p3, p4, p5, p6);
    }
    /**
     * 绑定最右的5个参数到此Func上，并且返回带有剩余参数的Func。
     */
    default Func1<P1, R> applyR(final P2 p2, final P3 p3, final P4 p4, final P5 p5, final P6 p6)
    {
        return (p1) -> this.invoke(p1, p2, p3, p4, p5, p6);
    }
    // endregion: apply from right
    // endregion: currying
}
