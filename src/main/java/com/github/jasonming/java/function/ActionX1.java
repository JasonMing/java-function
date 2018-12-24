/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

/**
 * 提供一个1个参数，无返回值，声明抛出类型为{@link X}的函数式接口。
 */
@FunctionalInterface
public interface ActionX1<P1, X extends Throwable>
        extends Action1<P1>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((ActionX1<P1, X>) (p1) -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(ActionX1.of((p1) -> foo())); }
     *
     * @param f 能适配ActionX1的lambda表达式或任意实例。
     *
     * @return {@code f}自身。
     */
    static <P1, X extends Throwable> ActionX1<P1, X> of(final ActionX1<P1, X> f)
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
     * @apiNote <code><b>void</b> invoke(p1)</code> &#8658; <code><b>R</b> invoke(p1)</code>
     */
    @Override
    default <R> FuncX1<P1, R, X> toFunc()
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
     * @apiNote <code><b>void</b> invoke(p1)</code> &#8658; <code><b>R</b> invoke(p1)</code>
     */
    @Override
    default <R> FuncX1<P1, R, X> toFunc(final R returnValue)
    {
        return (p1) ->
        {
            this.invokeV(p1);
            return returnValue;
        };
    }

    @Override
    @SuppressWarnings({"RedundantCast", "unchecked"})
    default void invokeV(final P1 p1)
    {
        ((ActionX1<P1, RuntimeException>)this).invokeVX(p1);
    }

    /**
     * 执行此Action，并不返回任何值，期间可能会抛出类型为{@link X}的异常。
     */
    void invokeVX(P1 p1) throws X;
}
