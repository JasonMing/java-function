/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

/**
 * 提供一个3个参数，返回值为{@link R}，声明抛出类型为{@link Exception}的函数式接口。
 */
@FunctionalInterface
public interface FuncE3<P1, P2, P3, R>
        extends FuncX3<P1, P2, P3, R, Exception>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((FuncE3<P1, P2, P3, R>) (p1, p2, p3) -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(FuncE3.of((p1, p2, p3) -> foo())); }
     *
     * @param f 能适配FuncE3的lambda表达式或任意实例。
     *
     * @return {@code f}自身。
     */
    static <P1, P2, P3, R> FuncE3<P1, P2, P3, R> of(final FuncE3<P1, P2, P3, R> f)
    {
        return f;
    }

    /**
     * 忽略Func的返回值使其适配对应的Action。
     *
     * @return 参数个数相同的Action。
     *
     * @apiNote <code><b>R</b> invoke(p1, p2, p3)</code> &#8658; <code><b>void</b> invoke(p1, p2, p3)</code>
     */
    @Override
    default ActionE3<P1, P2, P3> asAction()
    {
        return this::invoke;
    }

    // region: currying
    // region: apply from left
    /**
     * 绑定最左的1个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE2<P2, P3, R> apply(final P1 p1)
    {
        return (p2, p3) -> this.invoke(p1, p2, p3);
    }
    /**
     * 绑定最左的2个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE1<P3, R> apply(final P1 p1, final P2 p2)
    {
        return (p3) -> this.invoke(p1, p2, p3);
    }
    // endregion: apply from left
    // region: apply from right
    /**
     * 绑定最右的1个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE2<P1, P2, R> applyR(final P3 p3)
    {
        return (p1, p2) -> this.invoke(p1, p2, p3);
    }
    /**
     * 绑定最右的2个参数到此Func上，并且返回带有剩余参数的Func。
     */
    @Override
    default FuncE1<P1, R> applyR(final P2 p2, final P3 p3)
    {
        return (p1) -> this.invoke(p1, p2, p3);
    }
    // endregion: apply from right
    // endregion: currying
}
