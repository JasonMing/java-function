/*
 * Copyright (c) 2018 JasonMing All Rights Reserved.
 */

package com.github.jasonming.java.function;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JasonMing
 * @version 1.0.0
 * @since 1.0.0 (2018-02-10)
 */
public class FuncTests
{
    @Test
    public void test_Func0() throws Exception
    {
        final Func<String> func = () -> "foo";

        // invoke()
        Assert.assertEquals("foo", func.invoke());

        // Adapt to j.u.f.Supplier
        Assert.assertEquals("foo", func.get());
    }

    @Test
    public void test_Func1() throws Exception
    {
        final Func1<Integer, String> func = p1 -> "foo" + p1;

        // invoke()
        Assert.assertEquals("foo1", func.invoke(1));

        // Adapt to j.u.f.Function
        Assert.assertEquals("foo1", func.apply(1));
    }

    @Test
    public void test_Func2() throws Exception
    {
        final Func2<Integer, Object, String> func = (p1, p2) -> "foo" + p1 + p2;

        // invoke()
        Assert.assertEquals("foo1x", func.invoke(1, "x"));

        // Adapt to j.u.f.BiFunction
        Assert.assertEquals("foo1x", func.apply(1, "x"));
    }

    @Test
    public void test_FuncX0() throws Exception
    {
        final FuncX<String, Throwable> func = () -> TestHelpers.deadR();

        // Func.invoke()
        Assert.assertThat(func, TestHelpers.matchException(Exception.class, x -> x.invoke()));

        // invokeX()
        Assert.assertThat(func, TestHelpers.matchException(Exception.class, x -> x.invokeX()));
    }


    @Test
    public void test_FuncE0() throws Exception
    {
        final FuncE<String> func = () -> TestHelpers.deadR();

        // Func.invoke()
        Assert.assertThat(func, TestHelpers.matchException(Exception.class, x -> x.invoke()));

        // invokeX()
        Assert.assertThat(func, TestHelpers.matchException(Exception.class, x -> x.invokeX()));

        // Adapt to Callable
        Assert.assertThat(func, TestHelpers.matchException(Exception.class, x -> x.call()));
    }
}
