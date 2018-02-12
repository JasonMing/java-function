/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

/**
 * 提供一个无参数，无返回值，声明抛出类型为{@link Exception}的函数式接口。
 */
@FunctionalInterface
public interface ActionE
        extends ActionX<Exception>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((ActionE) () -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(ActionE.of(() -> foo())); }
     *
     * @param f 能适配ActionE的lambda表达式或任意实例
     *
     * @return {@code f}自身
     */
    static ActionE of(final ActionE f)
    {
        return f;
    }

    /**
     * 扩展Action的返回值到{@code <R>}使其转换为对应的Func，并使用{@code ret}作为返回值。
     *
     * @param ret 作为Function的返回值
     * @param <R> Function返回值的类型
     *
     * @return 参数个数相同的Func
     *
     * @apiNote <code><b>void</b> invoke()</code> &#8658; <code><b>R</b> invoke()</code>
     */
    @Override
    default <R> FuncE<R> toFunc(final R ret)
    {
        return () ->
        {
            this.invokeV();
            return ret;
        };
    }
}
