/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

/**
 * 提供一个2个参数，无返回值，声明抛出类型为{@link Exception}的函数式接口。
 */
@FunctionalInterface
public interface ActionE2<P1, P2>
        extends ActionX2<P1, P2, Exception>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((ActionE2<P1, P2>) (p1, p2) -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(ActionE2.of((p1, p2) -> foo())); }
     *
     * @param f 能适配ActionE2的lambda表达式或任意实例
     *
     * @return {@code f}自身
     */
    static <P1, P2> ActionE2<P1, P2> of(final ActionE2<P1, P2> f)
    {
        return f;
    }

    // region: currying


    // region: apply from left


    /**
     * 绑定最左的1个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionE1<P2> apply(final P1 p1)
    {
        return (p2) -> this.invokeV(p1, p2);
    }


    // endregion: apply from left


    // region: apply from right


    /**
     * 绑定最右的1个参数到此Action上，并且返回带有剩余参数的Action。
     */
    @Override
    default ActionE1<P1> applyR(final P2 p2)
    {
        return (p1) -> this.invokeV(p1, p2);
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
     * @apiNote <code><b>void</b> invoke(p1, p2)</code> &#8658; <code><b>R</b> invoke(p1, p2)</code>
     */
    @Override
    default <R> FuncE2<P1, P2, R> toFunc(final R ret)
    {
        return (p1, p2) ->
        {
            this.invokeV(p1, p2);
            return ret;
        };
    }
}
