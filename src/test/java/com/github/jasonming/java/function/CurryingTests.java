/*
 * Copyright (c) 2018 JasonMing All Rights Reserved.
 */

package com.github.jasonming.java.function;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JasonMing
 * @version 1.0.0
 * @since 1.0.0 (2018-02-10)
 */
public class CurryingTests
{
    @Test
    public void test_Func() throws Exception
    {
        runCurrying("Func",
                new Object[]
                {
                    (Func)() -> "foo",
                    (Func1)(p1) -> "foo",
                    (Func2)(p1, p2) -> "foo",
                    (Func3)(p1, p2, p3) -> "foo",
                    (Func4)(p1, p2, p3, p4) -> "foo",
                    (Func5)(p1, p2, p3, p4, p5) -> "foo",
                    (Func6)(p1, p2, p3, p4, p5, p6) -> "foo",
                    (Func7)(p1, p2, p3, p4, p5, p6, p7) -> "foo",
                    (Func8)(p1, p2, p3, p4, p5, p6, p7, p8) -> "foo",
                    (Func9)(p1, p2, p3, p4, p5, p6, p7, p8, p9) -> "foo"
                }
        );
    }

    @Test
    public void test_FuncX() throws Exception
    {
        runCurrying("FuncX",
                new Object[]
                {
                    (FuncX)() -> "foo",
                    (FuncX1)(p1) -> "foo",
                    (FuncX2)(p1, p2) -> "foo",
                    (FuncX3)(p1, p2, p3) -> "foo",
                    (FuncX4)(p1, p2, p3, p4) -> "foo",
                    (FuncX5)(p1, p2, p3, p4, p5) -> "foo",
                    (FuncX6)(p1, p2, p3, p4, p5, p6) -> "foo",
                    (FuncX7)(p1, p2, p3, p4, p5, p6, p7) -> "foo",
                    (FuncX8)(p1, p2, p3, p4, p5, p6, p7, p8) -> "foo",
                    (FuncX9)(p1, p2, p3, p4, p5, p6, p7, p8, p9) -> "foo"
                }
        );
    }

    @Test
    public void test_FuncE() throws Exception
    {
        runCurrying("FuncE",
                new Object[]
                {
                    (FuncE)() -> "foo",
                    (FuncE1)(p1) -> "foo",
                    (FuncE2)(p1, p2) -> "foo",
                    (FuncE3)(p1, p2, p3) -> "foo",
                    (FuncE4)(p1, p2, p3, p4) -> "foo",
                    (FuncE5)(p1, p2, p3, p4, p5) -> "foo",
                    (FuncE6)(p1, p2, p3, p4, p5, p6) -> "foo",
                    (FuncE7)(p1, p2, p3, p4, p5, p6, p7) -> "foo",
                    (FuncE8)(p1, p2, p3, p4, p5, p6, p7, p8) -> "foo",
                    (FuncE9)(p1, p2, p3, p4, p5, p6, p7, p8, p9) -> "foo"
                }
        );
    }

    @Test
    public void test_Action() throws Exception
    {
        runCurrying("Action",
                new Object[]
                {
                    (Action)() -> {},
                    (Action1)(p1) -> {},
                    (Action2)(p1, p2) -> {},
                    (Action3)(p1, p2, p3) -> {},
                    (Action4)(p1, p2, p3, p4) -> {},
                    (Action5)(p1, p2, p3, p4, p5) -> {},
                    (Action6)(p1, p2, p3, p4, p5, p6) -> {},
                    (Action7)(p1, p2, p3, p4, p5, p6, p7) -> {},
                    (Action8)(p1, p2, p3, p4, p5, p6, p7, p8) -> {},
                    (Action9)(p1, p2, p3, p4, p5, p6, p7, p8, p9) -> {}
                }
        );
    }

    @Test
    public void test_ActionX() throws Exception
    {
        runCurrying("ActionX",
                new Object[]
                {
                    (ActionX)() -> {},
                    (ActionX1)(p1) -> {},
                    (ActionX2)(p1, p2) -> {},
                    (ActionX3)(p1, p2, p3) -> {},
                    (ActionX4)(p1, p2, p3, p4) -> {},
                    (ActionX5)(p1, p2, p3, p4, p5) -> {},
                    (ActionX6)(p1, p2, p3, p4, p5, p6) -> {},
                    (ActionX7)(p1, p2, p3, p4, p5, p6, p7) -> {},
                    (ActionX8)(p1, p2, p3, p4, p5, p6, p7, p8) -> {},
                    (ActionX9)(p1, p2, p3, p4, p5, p6, p7, p8, p9) -> {}
                }
        );
    }

    @Test
    public void test_ActionE() throws Exception
    {
        runCurrying("ActionE",
                new Object[]
                {
                    (ActionE)() -> {},
                    (ActionE1)(p1) -> {},
                    (ActionE2)(p1, p2) -> {},
                    (ActionE3)(p1, p2, p3) -> {},
                    (ActionE4)(p1, p2, p3, p4) -> {},
                    (ActionE5)(p1, p2, p3, p4, p5) -> {},
                    (ActionE6)(p1, p2, p3, p4, p5, p6) -> {},
                    (ActionE7)(p1, p2, p3, p4, p5, p6, p7) -> {},
                    (ActionE8)(p1, p2, p3, p4, p5, p6, p7, p8) -> {},
                    (ActionE9)(p1, p2, p3, p4, p5, p6, p7, p8, p9) -> {}
                }
        );
    }

    private static void runCurrying(final String funcType, final Object[] funcInstances) throws Exception
    {
        Assert.assertEquals(10, funcInstances.length);

        final Class<?>[] funcClasses = IntStream.range(0, 10)
                .mapToObj(i -> Functions.propagate(() -> Class.forName("cn.com.ykse.commons.functions." + funcType + (i == 0 ? "" : i))))
                .toArray(Class<?>[]::new);

        for (int i = 2; i < 10; i++)
        {
            final Class<?> funcClass = funcClasses[i];
            final Object func = funcInstances[i];

            // Curry 1..i-1 arguments
            for (int j = 1; j < i; j++)
            {
                final Class<?>[] parameters = new Class<?>[j];
                Arrays.fill(parameters, Object.class);
                final Object[] arguments = new Object[j];

                // apply
                final Object curried = funcClass.getMethod("apply", parameters).invoke(func, arguments /* it is ok all null items */);
                Assert.assertTrue(funcClasses[i - j].isInstance(curried));

                // applyR
                final Object rcurried = funcClass.getMethod("applyR", parameters).invoke(func, arguments /* it is ok all null items */);
                Assert.assertTrue(funcClasses[i - j].isInstance(rcurried));
            }
        }
    }
}
