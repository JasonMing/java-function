/*
 * Copyright (c) 2018 JasonMing All Rights Reserved.
 */

package com.github.jasonming.java.function;

import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Matcher;

/**
 * @author JasonMing
 * @version 1.0.0
 * @since 1.0.0 (2018-02-10)
 */
public final class TestHelpers
{
    private TestHelpers() {}

    public static void deadV() throws Exception
    {
        throw new Exception();
    }

    public static <R> R deadR() throws Exception
    {
        throw new Exception();
    }

    public static void returnV()
    {
        // Nothing
    }

    public static <R> R returnR()
    {
        return null;
    }

    public static String returnS()
    {
        return null;
    }

    public static <T> Matcher<T> matcher(final FuncX1<T, Boolean, Throwable> matcher)
    {
        return new CustomTypeSafeMatcher<T>("")
        {
            @Override
            protected boolean matchesSafely(final T item)
            {
                return matcher.invoke(item);
            }
        };
    }

    public static <T> Matcher<T> matchException(final Class<? extends Throwable> expected, final ActionX1<T, Throwable> runner)
    {
        return matcher(x -> {
            try
            {
                runner.invokeVX(x);
            } catch (final Throwable e)
            {
                return expected.isInstance(e);
            }
            return false;
        });
    }

    public static <T> Matcher<T> matchNoException(final ActionX1<T, Throwable> runner)
    {
        return matcher(x -> {
            try
            {
                runner.invokeVX(x);
                return true;
            } catch (final Throwable e)
            {
                return false;
            }
        });
    }
}
