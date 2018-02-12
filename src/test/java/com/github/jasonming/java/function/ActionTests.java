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
public class ActionTests
{
    @Test
    public void test_Action0() throws Exception
    {
        final Action func = () -> {};

        // // Func.invoke()
        // Assert.assertNull(func.invoke());

        // invokeV()
        Assert.assertThat(func, TestHelpers.matchNoException(x -> x.invokeV()));

        // Adapt to Runnable
        Assert.assertThat(func, TestHelpers.matchNoException(x -> x.run()));
    }

    @Test
    public void test_Action1() throws Exception
    {
        final Action1<String> func = p1 -> {};

        // // Func.invoke()
        // Assert.assertNull(func.invoke(null));

        // invokeV()
        Assert.assertThat(func, TestHelpers.matchNoException(x -> x.invokeV(null)));

        // Adapt to j.u.f.Consumer
        Assert.assertThat(func, TestHelpers.matchNoException(x -> x.accept(null)));
    }

    @Test
    public void test_Action2() throws Exception
    {
        final Action2<Integer, String> func = (p1, p2) -> {};

        // // Func.invoke()
        // Assert.assertNull(func.invoke(null, null));

        // invokeV()
        Assert.assertThat(func, TestHelpers.matchNoException(x -> x.invokeV(null, null)));

        // Adapt to j.u.f.BiConsumer
        Assert.assertThat(func, TestHelpers.matchNoException(x -> x.accept(null, null)));
    }

    @Test
    public void test_ActionX0() throws Exception
    {
        final ActionX<Throwable> func = () -> TestHelpers.deadV();

        // // Func.invoke()
        // Assert.assertThat(func, TestHelpers.matchException(Exception.class, x -> x.invoke()));

        // // FuncX.invokeX()
        // Assert.assertThat(func, TestHelpers.matchException(Exception.class, x -> x.invokeX()));

        // Action.invokeV()
        Assert.assertThat(func, TestHelpers.matchException(Exception.class, x -> x.invokeV()));

        // invokeVX()
        Assert.assertThat(func, TestHelpers.matchException(Exception.class, x -> x.invokeVX()));
    }
}
