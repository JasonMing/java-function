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

    /**
     * {@link ActionX#of}的快捷方式。
     *
     * @param action 没有参数没有返回值的lambda表达式。
     *
     * @return {@code action}自身。
     *
     * @see ActionX#of
     */
    public static <X extends Throwable> ActionX<X> action(final ActionX<X> action)
    {
        return action;
    }

    /**
     * {@link ActionX1#of}的快捷方式。
     *
     * @param action 1个参数没有返回值的lambda表达式。
     *
     * @return {@code action}自身。
     *
     * @see ActionX1#of
     */
    public static <P1, X extends Throwable> ActionX1<P1, X> action(final ActionX1<P1, X> action)
    {
        return action;
    }

    /**
     * {@link ActionX2#of}的快捷方式。
     *
     * @param action 2个参数没有返回值的lambda表达式。
     *
     * @return {@code action}自身。
     *
     * @see ActionX2#of
     */
    public static <P1, P2, X extends Throwable> ActionX2<P1, P2, X> action(final ActionX2<P1, P2, X> action)
    {
        return action;
    }

    /**
     * {@link ActionX3#of}的快捷方式。
     *
     * @param action 3个参数没有返回值的lambda表达式。
     *
     * @return {@code action}自身。
     *
     * @see ActionX3#of
     */
    public static <P1, P2, P3, X extends Throwable> ActionX3<P1, P2, P3, X> action(final ActionX3<P1, P2, P3, X> action)
    {
        return action;
    }

    /**
     * {@link ActionX4#of}的快捷方式。
     *
     * @param action 4个参数没有返回值的lambda表达式。
     *
     * @return {@code action}自身。
     *
     * @see ActionX4#of
     */
    public static <P1, P2, P3, P4, X extends Throwable> ActionX4<P1, P2, P3, P4, X> action(final ActionX4<P1, P2, P3, P4, X> action)
    {
        return action;
    }

    /**
     * {@link ActionX5#of}的快捷方式。
     *
     * @param action 5个参数没有返回值的lambda表达式。
     *
     * @return {@code action}自身。
     *
     * @see ActionX5#of
     */
    public static <P1, P2, P3, P4, P5, X extends Throwable> ActionX5<P1, P2, P3, P4, P5, X> action(final ActionX5<P1, P2, P3, P4, P5, X> action)
    {
        return action;
    }

    /**
     * {@link ActionX6#of}的快捷方式。
     *
     * @param action 6个参数没有返回值的lambda表达式。
     *
     * @return {@code action}自身。
     *
     * @see ActionX6#of
     */
    public static <P1, P2, P3, P4, P5, P6, X extends Throwable> ActionX6<P1, P2, P3, P4, P5, P6, X> action(final ActionX6<P1, P2, P3, P4, P5, P6, X> action)
    {
        return action;
    }

    /**
     * {@link ActionX7#of}的快捷方式。
     *
     * @param action 7个参数没有返回值的lambda表达式。
     *
     * @return {@code action}自身。
     *
     * @see ActionX7#of
     */
    public static <P1, P2, P3, P4, P5, P6, P7, X extends Throwable> ActionX7<P1, P2, P3, P4, P5, P6, P7, X> action(final ActionX7<P1, P2, P3, P4, P5, P6, P7, X> action)
    {
        return action;
    }

    /**
     * {@link ActionX8#of}的快捷方式。
     *
     * @param action 8个参数没有返回值的lambda表达式。
     *
     * @return {@code action}自身。
     *
     * @see ActionX8#of
     */
    public static <P1, P2, P3, P4, P5, P6, P7, P8, X extends Throwable> ActionX8<P1, P2, P3, P4, P5, P6, P7, P8, X> action(final ActionX8<P1, P2, P3, P4, P5, P6, P7, P8, X> action)
    {
        return action;
    }

    /**
     * {@link ActionX9#of}的快捷方式。
     *
     * @param action 9个参数没有返回值的lambda表达式。
     *
     * @return {@code action}自身。
     *
     * @see ActionX9#of
     */
    public static <P1, P2, P3, P4, P5, P6, P7, P8, P9, X extends Throwable> ActionX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, X> action(final ActionX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, X> action)
    {
        return action;
    }

    /**
     * {@link FuncX#of}的快捷方式。
     *
     * @param func 没有参数返回{@link R}的lambda表达式。
     *
     * @return {@code func}自身。
     *
     * @see FuncX#of
     */
    public static <R, X extends Throwable> FuncX<R, X> func(final FuncX<R, X> func)
    {
        return func;
    }

    /**
     * {@link FuncX1#of}的快捷方式。
     *
     * @param func 1个参数返回{@link R}的lambda表达式。
     *
     * @return {@code func}自身。
     *
     * @see FuncX1#of
     */
    public static <P1, R, X extends Throwable> FuncX1<P1, R, X> func(final FuncX1<P1, R, X> func)
    {
        return func;
    }

    /**
     * {@link FuncX2#of}的快捷方式。
     *
     * @param func 2个参数返回{@link R}的lambda表达式。
     *
     * @return {@code func}自身。
     *
     * @see FuncX2#of
     */
    public static <P1, P2, R, X extends Throwable> FuncX2<P1, P2, R, X> func(final FuncX2<P1, P2, R, X> func)
    {
        return func;
    }

    /**
     * {@link FuncX3#of}的快捷方式。
     *
     * @param func 3个参数返回{@link R}的lambda表达式。
     *
     * @return {@code func}自身。
     *
     * @see FuncX3#of
     */
    public static <P1, P2, P3, R, X extends Throwable> FuncX3<P1, P2, P3, R, X> func(final FuncX3<P1, P2, P3, R, X> func)
    {
        return func;
    }

    /**
     * {@link FuncX4#of}的快捷方式。
     *
     * @param func 4个参数返回{@link R}的lambda表达式。
     *
     * @return {@code func}自身。
     *
     * @see FuncX4#of
     */
    public static <P1, P2, P3, P4, R, X extends Throwable> FuncX4<P1, P2, P3, P4, R, X> func(final FuncX4<P1, P2, P3, P4, R, X> func)
    {
        return func;
    }

    /**
     * {@link FuncX5#of}的快捷方式。
     *
     * @param func 5个参数返回{@link R}的lambda表达式。
     *
     * @return {@code func}自身。
     *
     * @see FuncX5#of
     */
    public static <P1, P2, P3, P4, P5, R, X extends Throwable> FuncX5<P1, P2, P3, P4, P5, R, X> func(final FuncX5<P1, P2, P3, P4, P5, R, X> func)
    {
        return func;
    }

    /**
     * {@link FuncX6#of}的快捷方式。
     *
     * @param func 6个参数返回{@link R}的lambda表达式。
     *
     * @return {@code func}自身。
     *
     * @see FuncX6#of
     */
    public static <P1, P2, P3, P4, P5, P6, R, X extends Throwable> FuncX6<P1, P2, P3, P4, P5, P6, R, X> func(final FuncX6<P1, P2, P3, P4, P5, P6, R, X> func)
    {
        return func;
    }

    /**
     * {@link FuncX7#of}的快捷方式。
     *
     * @param func 7个参数返回{@link R}的lambda表达式。
     *
     * @return {@code func}自身。
     *
     * @see FuncX7#of
     */
    public static <P1, P2, P3, P4, P5, P6, P7, R, X extends Throwable> FuncX7<P1, P2, P3, P4, P5, P6, P7, R, X> func(final FuncX7<P1, P2, P3, P4, P5, P6, P7, R, X> func)
    {
        return func;
    }

    /**
     * {@link FuncX8#of}的快捷方式。
     *
     * @param func 8个参数返回{@link R}的lambda表达式。
     *
     * @return {@code func}自身。
     *
     * @see FuncX8#of
     */
    public static <P1, P2, P3, P4, P5, P6, P7, P8, R, X extends Throwable> FuncX8<P1, P2, P3, P4, P5, P6, P7, P8, R, X> func(final FuncX8<P1, P2, P3, P4, P5, P6, P7, P8, R, X> func)
    {
        return func;
    }

    /**
     * {@link FuncX9#of}的快捷方式。
     *
     * @param func 9个参数返回{@link R}的lambda表达式。
     *
     * @return {@code func}自身。
     *
     * @see FuncX9#of
     */
    public static <P1, P2, P3, P4, P5, P6, P7, P8, P9, R, X extends Throwable> FuncX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R, X> func(final FuncX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R, X> func)
    {
        return func;
    }

    /**
     * {@link FuncX#asAction}的快捷方式，将{@code Func}实例转换为没有返回值的{@code Action}实例。
     *
     * @param func 没有参数返回{@link R}的lambda表达式，或{@link FuncX}实例。
     *
     * @return {@code func}的{@code void}返回形式。
     *
     * @see FuncX#asAction
     */
    public static <R, X extends Throwable> ActionX<X> asAction(final FuncX<R, X> func)
    {
        return func.asAction();
    }

    /**
     * {@link FuncX1#asAction}的快捷方式，将{@code Func}实例转换为没有返回值的{@code Action}实例。
     *
     * @param func 1个参数返回{@link R}的lambda表达式，或{@link FuncX1}实例。
     *
     * @return {@code func}的{@code void}返回形式。
     *
     * @see FuncX1#asAction
     */
    public static <P1, R, X extends Throwable> ActionX1<P1, X> asAction(final FuncX1<P1, R, X> func)
    {
        return func.asAction();
    }

    /**
     * {@link FuncX2#asAction}的快捷方式，将{@code Func}实例转换为没有返回值的{@code Action}实例。
     *
     * @param func 2个参数返回{@link R}的lambda表达式，或{@link FuncX2}实例。
     *
     * @return {@code func}的{@code void}返回形式。
     *
     * @see FuncX2#asAction
     */
    public static <P1, P2, R, X extends Throwable> ActionX2<P1, P2, X> asAction(final FuncX2<P1, P2, R, X> func)
    {
        return func.asAction();
    }

    /**
     * {@link FuncX3#asAction}的快捷方式，将{@code Func}实例转换为没有返回值的{@code Action}实例。
     *
     * @param func 3个参数返回{@link R}的lambda表达式，或{@link FuncX3}实例。
     *
     * @return {@code func}的{@code void}返回形式。
     *
     * @see FuncX3#asAction
     */
    public static <P1, P2, P3, R, X extends Throwable> ActionX3<P1, P2, P3, X> asAction(final FuncX3<P1, P2, P3, R, X> func)
    {
        return func.asAction();
    }

    /**
     * {@link FuncX4#asAction}的快捷方式，将{@code Func}实例转换为没有返回值的{@code Action}实例。
     *
     * @param func 4个参数返回{@link R}的lambda表达式，或{@link FuncX4}实例。
     *
     * @return {@code func}的{@code void}返回形式。
     *
     * @see FuncX4#asAction
     */
    public static <P1, P2, P3, P4, R, X extends Throwable> ActionX4<P1, P2, P3, P4, X> asAction(final FuncX4<P1, P2, P3, P4, R, X> func)
    {
        return func.asAction();
    }

    /**
     * {@link FuncX5#asAction}的快捷方式，将{@code Func}实例转换为没有返回值的{@code Action}实例。
     *
     * @param func 5个参数返回{@link R}的lambda表达式，或{@link FuncX5}实例。
     *
     * @return {@code func}的{@code void}返回形式。
     *
     * @see FuncX5#asAction
     */
    public static <P1, P2, P3, P4, P5, R, X extends Throwable> ActionX5<P1, P2, P3, P4, P5, X> asAction(final FuncX5<P1, P2, P3, P4, P5, R, X> func)
    {
        return func.asAction();
    }

    /**
     * {@link FuncX6#asAction}的快捷方式，将{@code Func}实例转换为没有返回值的{@code Action}实例。
     *
     * @param func 6个参数返回{@link R}的lambda表达式，或{@link FuncX6}实例。
     *
     * @return {@code func}的{@code void}返回形式。
     *
     * @see FuncX6#asAction
     */
    public static <P1, P2, P3, P4, P5, P6, R, X extends Throwable> ActionX6<P1, P2, P3, P4, P5, P6, X> asAction(final FuncX6<P1, P2, P3, P4, P5, P6, R, X> func)
    {
        return func.asAction();
    }

    /**
     * {@link FuncX7#asAction}的快捷方式，将{@code Func}实例转换为没有返回值的{@code Action}实例。
     *
     * @param func 7个参数返回{@link R}的lambda表达式，或{@link FuncX7}实例。
     *
     * @return {@code func}的{@code void}返回形式。
     *
     * @see FuncX7#asAction
     */
    public static <P1, P2, P3, P4, P5, P6, P7, R, X extends Throwable> ActionX7<P1, P2, P3, P4, P5, P6, P7, X> asAction(final FuncX7<P1, P2, P3, P4, P5, P6, P7, R, X> func)
    {
        return func.asAction();
    }

    /**
     * {@link FuncX8#asAction}的快捷方式，将{@code Func}实例转换为没有返回值的{@code Action}实例。
     *
     * @param func 8个参数返回{@link R}的lambda表达式，或{@link FuncX8}实例。
     *
     * @return {@code func}的{@code void}返回形式。
     *
     * @see FuncX8#asAction
     */
    public static <P1, P2, P3, P4, P5, P6, P7, P8, R, X extends Throwable> ActionX8<P1, P2, P3, P4, P5, P6, P7, P8, X> asAction(final FuncX8<P1, P2, P3, P4, P5, P6, P7, P8, R, X> func)
    {
        return func.asAction();
    }

    /**
     * {@link FuncX9#asAction}的快捷方式，将{@code Func}实例转换为没有返回值的{@code Action}实例。
     *
     * @param func 9个参数返回{@link R}的lambda表达式，或{@link FuncX9}实例。
     *
     * @return {@code func}的{@code void}返回形式。
     *
     * @see FuncX9#asAction
     */
    public static <P1, P2, P3, P4, P5, P6, P7, P8, P9, R, X extends Throwable> ActionX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, X> asAction(final FuncX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R, X> func)
    {
        return func.asAction();
    }

    /**
     * {@link ActionX#toFunc()}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code null}为返回值的{@code Func}实例。
     *
     * @param action 没有参数没有返回值的lambda表达式，或{@link ActionX}实例。
     *
     * @return 返回值为{@code null}的{@code action}。
     *
     * @see ActionX#toFunc()
     */
    public static <R, X extends Throwable> FuncX<R, X> toFunc(final ActionX<X> action)
    {
        return action.toFunc();
    }

    /**
     * {@link ActionX1#toFunc()}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code null}为返回值的{@code Func}实例。
     *
     * @param action 1个参数没有返回值的lambda表达式，或{@link ActionX1}实例。
     *
     * @return 返回值为{@code null}的{@code action}。
     *
     * @see ActionX1#toFunc()
     */
    public static <P1, R, X extends Throwable> FuncX1<P1, R, X> toFunc(final ActionX1<P1, X> action)
    {
        return action.toFunc();
    }

    /**
     * {@link ActionX2#toFunc()}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code null}为返回值的{@code Func}实例。
     *
     * @param action 2个参数没有返回值的lambda表达式，或{@link ActionX2}实例。
     *
     * @return 返回值为{@code null}的{@code action}。
     *
     * @see ActionX2#toFunc()
     */
    public static <P1, P2, R, X extends Throwable> FuncX2<P1, P2, R, X> toFunc(final ActionX2<P1, P2, X> action)
    {
        return action.toFunc();
    }

    /**
     * {@link ActionX3#toFunc()}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code null}为返回值的{@code Func}实例。
     *
     * @param action 3个参数没有返回值的lambda表达式，或{@link ActionX3}实例。
     *
     * @return 返回值为{@code null}的{@code action}。
     *
     * @see ActionX3#toFunc()
     */
    public static <P1, P2, P3, R, X extends Throwable> FuncX3<P1, P2, P3, R, X> toFunc(final ActionX3<P1, P2, P3, X> action)
    {
        return action.toFunc();
    }

    /**
     * {@link ActionX4#toFunc()}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code null}为返回值的{@code Func}实例。
     *
     * @param action 4个参数没有返回值的lambda表达式，或{@link ActionX4}实例。
     *
     * @return 返回值为{@code null}的{@code action}。
     *
     * @see ActionX4#toFunc()
     */
    public static <P1, P2, P3, P4, R, X extends Throwable> FuncX4<P1, P2, P3, P4, R, X> toFunc(final ActionX4<P1, P2, P3, P4, X> action)
    {
        return action.toFunc();
    }

    /**
     * {@link ActionX5#toFunc()}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code null}为返回值的{@code Func}实例。
     *
     * @param action 5个参数没有返回值的lambda表达式，或{@link ActionX5}实例。
     *
     * @return 返回值为{@code null}的{@code action}。
     *
     * @see ActionX5#toFunc()
     */
    public static <P1, P2, P3, P4, P5, R, X extends Throwable> FuncX5<P1, P2, P3, P4, P5, R, X> toFunc(final ActionX5<P1, P2, P3, P4, P5, X> action)
    {
        return action.toFunc();
    }

    /**
     * {@link ActionX6#toFunc()}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code null}为返回值的{@code Func}实例。
     *
     * @param action 6个参数没有返回值的lambda表达式，或{@link ActionX6}实例。
     *
     * @return 返回值为{@code null}的{@code action}。
     *
     * @see ActionX6#toFunc()
     */
    public static <P1, P2, P3, P4, P5, P6, R, X extends Throwable> FuncX6<P1, P2, P3, P4, P5, P6, R, X> toFunc(final ActionX6<P1, P2, P3, P4, P5, P6, X> action)
    {
        return action.toFunc();
    }

    /**
     * {@link ActionX7#toFunc()}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code null}为返回值的{@code Func}实例。
     *
     * @param action 7个参数没有返回值的lambda表达式，或{@link ActionX7}实例。
     *
     * @return 返回值为{@code null}的{@code action}。
     *
     * @see ActionX7#toFunc()
     */
    public static <P1, P2, P3, P4, P5, P6, P7, R, X extends Throwable> FuncX7<P1, P2, P3, P4, P5, P6, P7, R, X> toFunc(final ActionX7<P1, P2, P3, P4, P5, P6, P7, X> action)
    {
        return action.toFunc();
    }

    /**
     * {@link ActionX8#toFunc()}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code null}为返回值的{@code Func}实例。
     *
     * @param action 8个参数没有返回值的lambda表达式，或{@link ActionX8}实例。
     *
     * @return 返回值为{@code null}的{@code action}。
     *
     * @see ActionX8#toFunc()
     */
    public static <P1, P2, P3, P4, P5, P6, P7, P8, R, X extends Throwable> FuncX8<P1, P2, P3, P4, P5, P6, P7, P8, R, X> toFunc(final ActionX8<P1, P2, P3, P4, P5, P6, P7, P8, X> action)
    {
        return action.toFunc();
    }

    /**
     * {@link ActionX9#toFunc()}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code null}为返回值的{@code Func}实例。
     *
     * @param action 9个参数没有返回值的lambda表达式，或{@link ActionX9}实例。
     *
     * @return 返回值为{@code null}的{@code action}。
     *
     * @see ActionX9#toFunc()
     */
    public static <P1, P2, P3, P4, P5, P6, P7, P8, P9, R, X extends Throwable> FuncX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R, X> toFunc(final ActionX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, X> action)
    {
        return action.toFunc();
    }

    /**
     * {@link ActionX#toFunc(R)}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code returnValue}为返回值的{@code Func}实例。
     *
     * @param action      没有参数没有返回值的lambda表达式，或{@link ActionX}实例。
     * @param returnValue 作为{@link ActionX}的返回值。
     *
     * @return 返回值为{@code returnValue}的{@code action}。
     *
     * @see ActionX#toFunc(R)
     */
    public static <R, X extends Throwable> FuncX<R, X> toFunc(final ActionX<X> action, final R returnValue)
    {
        return action.toFunc(returnValue);
    }

    /**
     * {@link ActionX1#toFunc(R)}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code returnValue}为返回值的{@code Func}实例。
     *
     * @param action      1个参数没有返回值的lambda表达式，或{@link ActionX1}实例。
     * @param returnValue 作为{@link ActionX1}的返回值。
     *
     * @return 返回值为{@code returnValue}的{@code action}。
     *
     * @see ActionX1#toFunc(R)
     */
    public static <P1, R, X extends Throwable> FuncX1<P1, R, X> toFunc(final ActionX1<P1, X> action, final R returnValue)
    {
        return action.toFunc(returnValue);
    }

    /**
     * {@link ActionX2#toFunc(R)}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code returnValue}为返回值的{@code Func}实例。
     *
     * @param action      2个参数没有返回值的lambda表达式，或{@link ActionX2}实例。
     * @param returnValue 作为{@link ActionX2}的返回值。
     *
     * @return 返回值为{@code returnValue}的{@code action}。
     *
     * @see ActionX2#toFunc(R)
     */
    public static <P1, P2, R, X extends Throwable> FuncX2<P1, P2, R, X> toFunc(final ActionX2<P1, P2, X> action, final R returnValue)
    {
        return action.toFunc(returnValue);
    }

    /**
     * {@link ActionX3#toFunc(R)}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code returnValue}为返回值的{@code Func}实例。
     *
     * @param action      3个参数没有返回值的lambda表达式，或{@link ActionX3}实例。
     * @param returnValue 作为{@link ActionX3}的返回值。
     *
     * @return 返回值为{@code returnValue}的{@code action}。
     *
     * @see ActionX3#toFunc(R)
     */
    public static <P1, P2, P3, R, X extends Throwable> FuncX3<P1, P2, P3, R, X> toFunc(final ActionX3<P1, P2, P3, X> action, final R returnValue)
    {
        return action.toFunc(returnValue);
    }

    /**
     * {@link ActionX4#toFunc(R)}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code returnValue}为返回值的{@code Func}实例。
     *
     * @param action      4个参数没有返回值的lambda表达式，或{@link ActionX4}实例。
     * @param returnValue 作为{@link ActionX4}的返回值。
     *
     * @return 返回值为{@code returnValue}的{@code action}。
     *
     * @see ActionX4#toFunc(R)
     */
    public static <P1, P2, P3, P4, R, X extends Throwable> FuncX4<P1, P2, P3, P4, R, X> toFunc(final ActionX4<P1, P2, P3, P4, X> action, final R returnValue)
    {
        return action.toFunc(returnValue);
    }

    /**
     * {@link ActionX5#toFunc(R)}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code returnValue}为返回值的{@code Func}实例。
     *
     * @param action      5个参数没有返回值的lambda表达式，或{@link ActionX5}实例。
     * @param returnValue 作为{@link ActionX5}的返回值。
     *
     * @return 返回值为{@code returnValue}的{@code action}。
     *
     * @see ActionX5#toFunc(R)
     */
    public static <P1, P2, P3, P4, P5, R, X extends Throwable> FuncX5<P1, P2, P3, P4, P5, R, X> toFunc(final ActionX5<P1, P2, P3, P4, P5, X> action, final R returnValue)
    {
        return action.toFunc(returnValue);
    }

    /**
     * {@link ActionX6#toFunc(R)}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code returnValue}为返回值的{@code Func}实例。
     *
     * @param action      6个参数没有返回值的lambda表达式，或{@link ActionX6}实例。
     * @param returnValue 作为{@link ActionX6}的返回值。
     *
     * @return 返回值为{@code returnValue}的{@code action}。
     *
     * @see ActionX6#toFunc(R)
     */
    public static <P1, P2, P3, P4, P5, P6, R, X extends Throwable> FuncX6<P1, P2, P3, P4, P5, P6, R, X> toFunc(final ActionX6<P1, P2, P3, P4, P5, P6, X> action, final R returnValue)
    {
        return action.toFunc(returnValue);
    }

    /**
     * {@link ActionX7#toFunc(R)}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code returnValue}为返回值的{@code Func}实例。
     *
     * @param action      7个参数没有返回值的lambda表达式，或{@link ActionX7}实例。
     * @param returnValue 作为{@link ActionX7}的返回值。
     *
     * @return 返回值为{@code returnValue}的{@code action}。
     *
     * @see ActionX7#toFunc(R)
     */
    public static <P1, P2, P3, P4, P5, P6, P7, R, X extends Throwable> FuncX7<P1, P2, P3, P4, P5, P6, P7, R, X> toFunc(final ActionX7<P1, P2, P3, P4, P5, P6, P7, X> action, final R returnValue)
    {
        return action.toFunc(returnValue);
    }

    /**
     * {@link ActionX8#toFunc(R)}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code returnValue}为返回值的{@code Func}实例。
     *
     * @param action      8个参数没有返回值的lambda表达式，或{@link ActionX8}实例。
     * @param returnValue 作为{@link ActionX8}的返回值。
     *
     * @return 返回值为{@code returnValue}的{@code action}。
     *
     * @see ActionX8#toFunc(R)
     */
    public static <P1, P2, P3, P4, P5, P6, P7, P8, R, X extends Throwable> FuncX8<P1, P2, P3, P4, P5, P6, P7, P8, R, X> toFunc(final ActionX8<P1, P2, P3, P4, P5, P6, P7, P8, X> action, final R returnValue)
    {
        return action.toFunc(returnValue);
    }

    /**
     * {@link ActionX9#toFunc(R)}的快捷方式，将没有返回值的{@code Action}实例转换为以{@code returnValue}为返回值的{@code Func}实例。
     *
     * @param action      9个参数没有返回值的lambda表达式，或{@link ActionX9}实例。
     * @param returnValue 作为{@link ActionX9}的返回值。
     *
     * @return 返回值为{@code returnValue}的{@code action}。
     *
     * @see ActionX9#toFunc(R)
     */
    public static <P1, P2, P3, P4, P5, P6, P7, P8, P9, R, X extends Throwable> FuncX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R, X> toFunc(final ActionX9<P1, P2, P3, P4, P5, P6, P7, P8, P9, X> action, final R returnValue)
    {
        return action.toFunc(returnValue);
    }
}
