/*
 * Copyright (c) 2018 JasonMing All Rights Reserved.
 */

package com.github.jasonming.java.function;

/**
 * 函数式接口常用工具方法。
 *
 * @author JasonMing
 * @version 1.0.0
 * @since 1.0.0 (2018-02-10)
 */
public final class Functions
{
    private Functions() {}

    /**
     * 执行{@code f}中的动作，并返回{@code f}的返回值，执行{@code f}时所抛出的异常将被<strong>原样传播</strong>。
     * <p>
     * 此方法的不声明抛出任何受检异常（checked-exception)，但并不会吞掉（ignore）或对原异常进行任何包装（wrap）。
     * <p>
     * 适用场景：
     * <ul>
     *     <li>高层通过AOP拦截器进行统一的异常处理，原生异常并不会被迫进行无用包装，拦截器亦无需使用复杂的逻辑对截获的异常进行类型判断及解包。</li>
     *     <li>函数式工具方法，不再需要限制传入的lambda函数不能抛出受检异常，同时方法自身无需声明抛出受检异常，方便调用者的使用。</li>
     * </ul>
     *
     * @param f   返回类型为{@link R}的任意动作，并可以抛出任意类型异常，抛出的异常会被正常地向上传播。
     * @param <R> 返回值类型
     *
     * @return {@code f}的返回值
     *
     * @since 1.0.0 (2018-02-10)
     */
    public static <R> R propagate(final FuncX<R, ?> f)
    {
        return f.invoke();
    }

    /**
     * 执行{@code f}中的动作，执行{@code f}时所抛出的异常将被<strong>原样传播</strong>。
     * <p>
     * 此方法的不声明抛出任何受检异常（checked-exception)，但并不会吞掉（ignore）或对原异常进行任何包装（wrap）。
     * <p>
     * 适用场景：
     * <ul>
     *     <li>高层通过AOP拦截器进行统一的异常处理，原生异常并不会被迫进行无用包装，拦截器亦无需使用复杂的逻辑对截获的异常进行类型判断及解包。</li>
     *     <li>函数式工具方法，不再需要限制传入的lambda函数不能抛出受检异常，同时方法自身无需声明抛出受检异常，方便调用者的使用。</li>
     * </ul>
     *
     * @param f 返回类型为{@code void}的任意动作，并可以抛出任意类型异常，抛出的异常会被正常地向上传播。
     *
     * @since 1.0.0 (2018-02-10)
     */
    public static void propagate(final ActionX<?> f)
    {
        f.invokeV();
    }

    // region: of

    /**
     * {@link Action#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link ActionX#of}。
     *
     * @param f 能适配Action的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Action#of
     */
    public static Action of(final Action f)
    {
        return f;
    }

    /**
     * {@link Action1#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link ActionX1#of}。
     *
     * @param f 能适配Action1的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Action1#of
     */
    public static <P1> Action1<P1> of(final Action1<P1> f)
    {
        return f;
    }

    /**
     * {@link Action2#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link ActionX2#of}。
     *
     * @param f 能适配Action2的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Action2#of
     */
    public static <P1, P2> Action2<P1, P2> of(final Action2<P1, P2> f)
    {
        return f;
    }

    /**
     * {@link Action3#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link ActionX3#of}。
     *
     * @param f 能适配Action3的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Action3#of
     */
    public static <P1, P2, P3> Action3<P1, P2, P3> of(final Action3<P1, P2, P3> f)
    {
        return f;
    }

    /**
     * {@link Action4#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link ActionX4#of}。
     *
     * @param f 能适配Action4的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Action4#of
     */
    public static <P1, P2, P3, P4> Action4<P1, P2, P3, P4> of(final Action4<P1, P2, P3, P4> f)
    {
        return f;
    }

    /**
     * {@link Action5#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link ActionX5#of}。
     *
     * @param f 能适配Action5的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Action5#of
     */
    public static <P1, P2, P3, P4, P5> Action5<P1, P2, P3, P4, P5> of(final Action5<P1, P2, P3, P4, P5> f)
    {
        return f;
    }

    /**
     * {@link Action6#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link ActionX6#of}。
     *
     * @param f 能适配Action6的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Action6#of
     */
    public static <P1, P2, P3, P4, P5, P6> Action6<P1, P2, P3, P4, P5, P6> of(final Action6<P1, P2, P3, P4, P5, P6> f)
    {
        return f;
    }

    /**
     * {@link Action7#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link ActionX7#of}。
     *
     * @param f 能适配Action7的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Action7#of
     */
    public static <P1, P2, P3, P4, P5, P6, P7> Action7<P1, P2, P3, P4, P5, P6, P7> of(final Action7<P1, P2, P3, P4, P5, P6, P7> f)
    {
        return f;
    }

    /**
     * {@link Action8#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link ActionX8#of}。
     *
     * @param f 能适配Action8的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Action8#of
     */
    public static <P1, P2, P3, P4, P5, P6, P7, P8> Action8<P1, P2, P3, P4, P5, P6, P7, P8> of(final Action8<P1, P2, P3, P4, P5, P6, P7, P8> f)
    {
        return f;
    }

    /**
     * {@link Action9#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link ActionX9#of}。
     *
     * @param f 能适配Action9的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Action9#of
     */
    public static <P1, P2, P3, P4, P5, P6, P7, P8, P9> Action9<P1, P2, P3, P4, P5, P6, P7, P8, P9> of(final Action9<P1, P2, P3, P4, P5, P6, P7, P8, P9> f)
    {
        return f;
    }

    /**
     * {@link Func#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link FuncX#of}。
     *
     * @param f 能适配Func的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Func#of
     */
    public static <R> Func<R> of(final Func<R> f)
    {
        return f;
    }

    /**
     * {@link Func1#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link FuncX1#of}。
     *
     * @param f 能适配Func1的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Func1#of
     */
    public static <P1, R> Func1<P1, R> of(final Func1<P1, R> f)
    {
        return f;
    }

    /**
     * {@link Func2#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link FuncX2#of}。
     *
     * @param f 能适配Func2的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Func2#of
     */
    public static <P1, P2, R> Func2<P1, P2, R> of(final Func2<P1, P2, R> f)
    {
        return f;
    }

    /**
     * {@link Func3#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link FuncX3#of}。
     *
     * @param f 能适配Func3的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Func3#of
     */
    public static <P1, P2, P3, R> Func3<P1, P2, P3, R> of(final Func3<P1, P2, P3, R> f)
    {
        return f;
    }

    /**
     * {@link Func4#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link FuncX4#of}。
     *
     * @param f 能适配Func4的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Func4#of
     */
    public static <P1, P2, P3, P4, R> Func4<P1, P2, P3, P4, R> of(final Func4<P1, P2, P3, P4, R> f)
    {
        return f;
    }

    /**
     * {@link Func5#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link FuncX5#of}。
     *
     * @param f 能适配Func5的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Func5#of
     */
    public static <P1, P2, P3, P4, P5, R> Func5<P1, P2, P3, P4, P5, R> of(final Func5<P1, P2, P3, P4, P5, R> f)
    {
        return f;
    }

    /**
     * {@link Func6#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link FuncX6#of}。
     *
     * @param f 能适配Func6的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Func6#of
     */
    public static <P1, P2, P3, P4, P5, P6, R> Func6<P1, P2, P3, P4, P5, P6, R> of(final Func6<P1, P2, P3, P4, P5, P6, R> f)
    {
        return f;
    }

    /**
     * {@link Func7#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link FuncX7#of}。
     *
     * @param f 能适配Func7的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Func7#of
     */
    public static <P1, P2, P3, P4, P5, P6, P7, R> Func7<P1, P2, P3, P4, P5, P6, P7, R> of(final Func7<P1, P2, P3, P4, P5, P6, P7, R> f)
    {
        return f;
    }

    /**
     * {@link Func8#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link FuncX8#of}。
     *
     * @param f 能适配Func8的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Func8#of
     */
    public static <P1, P2, P3, P4, P5, P6, P7, P8, R> Func8<P1, P2, P3, P4, P5, P6, P7, P8, R> of(final Func8<P1, P2, P3, P4, P5, P6, P7, P8, R> f)
    {
        return f;
    }

    /**
     * {@link Func9#of}的快捷方式，为了语义明确使用带有异常声明的版本请直接使用{@link FuncX9#of}。
     *
     * @param f 能适配Func9的lambda表达式或任意实例
     *
     * @return {@code f}自身
     *
     * @see Func9#of
     */
    public static <P1, P2, P3, P4, P5, P6, P7, P8, P9, R> Func9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> of(final Func9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> f)
    {
        return f;
    }

    // endregion: of

}
