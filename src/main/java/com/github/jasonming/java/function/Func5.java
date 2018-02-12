/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

/**
 * 提供一个5个参数，返回值为{@link R}，无异常抛出声明的函数式接口。
 */
@FunctionalInterface
public interface Func5<P1, P2, P3, P4, P5, R>
        extends Action5<P1, P2, P3, P4, P5>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((Func5<P1, P2, P3, P4, P5, R>) (p1, p2, p3, p4, p5) -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(Func5.of((p1, p2, p3, p4, p5) -> foo())); }
     *
     * @param f 能适配Func5的lambda表达式或任意实例
     *
     * @return {@code f}自身
     */
    static <P1, P2, P3, P4, P5, R> Func5<P1, P2, P3, P4, P5, R> of(final Func5<P1, P2, P3, P4, P5, R> f)
    {
        return f;
    }

    /**
     * 执行此Func，并返回类型为{@link R}的返回值。
     */
    R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5);

    @Override
    default void invokeV(final P1 p1, final P2 p2, final P3 p3, final P4 p4, final P5 p5)
    {
        this.invoke(p1, p2, p3, p4, p5);
    }

    // region: currying

    // region: apply from left

    /**
     * 绑定最左的1个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default Func4<P2, P3, P4, P5, R> apply(final P1 p1)
    {
        return (p2, p3, p4, p5) -> this.invoke(p1, p2, p3, p4, p5);
    }

    /**
     * 绑定最左的2个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default Func3<P3, P4, P5, R> apply(final P1 p1, final P2 p2)
    {
        return (p3, p4, p5) -> this.invoke(p1, p2, p3, p4, p5);
    }

    /**
     * 绑定最左的3个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default Func2<P4, P5, R> apply(final P1 p1, final P2 p2, final P3 p3)
    {
        return (p4, p5) -> this.invoke(p1, p2, p3, p4, p5);
    }

    /**
     * 绑定最左的4个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default Func1<P5, R> apply(final P1 p1, final P2 p2, final P3 p3, final P4 p4)
    {
        return (p5) -> this.invoke(p1, p2, p3, p4, p5);
    }

    // endregion: apply from left

    // region: apply from right

    /**
     * 绑定最右的1个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default Func4<P1, P2, P3, P4, R> applyR(final P5 p5)
    {
        return (p1, p2, p3, p4) -> this.invoke(p1, p2, p3, p4, p5);
    }

    /**
     * 绑定最右的2个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default Func3<P1, P2, P3, R> applyR(final P4 p4, final P5 p5)
    {
        return (p1, p2, p3) -> this.invoke(p1, p2, p3, p4, p5);
    }

    /**
     * 绑定最右的3个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default Func2<P1, P2, R> applyR(final P3 p3, final P4 p4, final P5 p5)
    {
        return (p1, p2) -> this.invoke(p1, p2, p3, p4, p5);
    }

    /**
     * 绑定最右的4个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default Func1<P1, R> applyR(final P2 p2, final P3 p3, final P4 p4, final P5 p5)
    {
        return (p1) -> this.invoke(p1, p2, p3, p4, p5);
    }

    // endregion: apply from right

    // endregion: currying
}
