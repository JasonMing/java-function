/*
 * GENERATED FILE: any modifications will be overridden after regenerating.
 */

package com.github.jasonming.java.function;

/**
 * 提供一个无参数，返回值为{@link R}，声明抛出类型为{@link X}的函数式接口。
 */
@FunctionalInterface
public interface FuncX<R, X extends Throwable>
        extends Func<R>
{
    /**
     * 为lambda表达式提供简便的类型声明。
     * <p>
     * 通常，要在参数中使用lambda表达式并且指定类型，必须带上所有的泛型参数，导致代码冗余，例如：
     * <p>
     * {@code map((FuncX<R, X>) () -> foo()); }
     * <p>
     * 通过此方法，可简化为：
     * <p>
     * {@code map(FuncX.of(() -> foo())); }
     *
     * @param f 能适配FuncX的lambda表达式或任意实例。
     *
     * @return {@code f}自身。
     */
    static <R, X extends Throwable> FuncX<R, X> of(final FuncX<R, X> f)
    {
        return f;
    }

    /**
     * 忽略Func的返回值使其适配对应的Action。
     *
     * @return 参数个数相同的Action。
     *
     * @apiNote <code><b>R</b> invoke()</code> &#8658; <code><b>void</b> invoke()</code>
     */
    @Override
    default ActionX<X> asAction()
    {
        return this::invoke;
    }

    @Override
    @SuppressWarnings({"RedundantCast", "unchecked"})
    default R invoke()
    {
        return ((FuncX<R, RuntimeException>)this).invokeX();
    }

    /**
     * 执行此Func，并返回类型为{@link R}的返回值，期间可能会抛出类型为{@link X}的异常。
     */
    R invokeX() throws X;
}
