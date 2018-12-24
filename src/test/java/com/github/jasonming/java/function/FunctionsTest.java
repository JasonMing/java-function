package com.github.jasonming.java.function;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JasonMing
 * @version 1.0.0
 * @since 1.0.0 (2018-02-10)
 */
public class FunctionsTest
{
    private static void action() {}

    private static String func() { return null; }

    private static <R> R funcGeneric() { return null; }

    private static void deadAction() throws Exception { throw new Exception(); }

    private static String deadFunc() throws Exception { throw new Exception(); }

    private static <R> R deadFuncGeneric() throws Exception { throw new Exception(); }

    @Test
    public void propagate() throws Exception
    {
        Functions.propagate(() -> action());
        Assert.assertNull(Functions.propagate(() -> func()));
        Assert.assertNull(Functions.propagate(() -> funcGeneric()));
        Assert.assertNull(Functions.<String>propagate(() -> funcGeneric()));

        Assert.assertThat(this, TestHelpers.matchException(Exception.class, x -> Functions.propagate(() -> deadAction())));
        Assert.assertThat(this, TestHelpers.matchException(Exception.class, x -> Functions.propagate(() -> deadFunc())));
        Assert.assertThat(this, TestHelpers.matchException(Exception.class, x -> Functions.propagate(() -> deadFuncGeneric())));
        Assert.assertThat(this, TestHelpers.matchException(Exception.class, x -> Functions.<String>propagate(() -> deadFuncGeneric())));
    }

    @Test
    @SuppressWarnings("unused")
    public void of_staticTyped() throws Exception
    {
        Functions.action(() -> {});
        // Functions.action(() -> "");
        Functions.action(() -> TestHelpers.returnV());
        Functions.action(() -> TestHelpers.returnR());
        Functions.action(() -> TestHelpers.returnS());
        Functions.action(p1 -> {});
        // Functions.action(p1 -> "");
        Functions.action(p1 -> TestHelpers.returnV());
        Functions.action(p1 -> TestHelpers.returnR());
        Functions.action(p1 -> TestHelpers.returnS());

        // Functions.func(() -> {});
        Functions.func(() -> "");
        // Functions.func(() -> TestHelpers.returnV());
        Functions.func(() -> TestHelpers.returnR());
        Functions.func(() -> TestHelpers.returnS());
        // Functions.func(p1 -> {});
        Functions.func(p1 -> "");
        // Functions.func(p1 -> TestHelpers.returnV());
        Functions.func(p1 -> TestHelpers.returnR());
        Functions.func(p1 -> TestHelpers.returnS());
    }

    private static void callerV(final Runnable f) { }
    // Could not overload between Action and Func, otherwise, the non-void expression not be recognized.
    // private static void callerV(final Supplier<?> f) { }

    private static <R> R callerR(final Runnable f) { return null; }
    // Could not overload between Action and Func, otherwise, the non-void expression not be recognized.
    // private static <R> R callerR(final Supplier<R> f) { return null; }

    // @Test
    // @SuppressWarnings({"unused", "ResultOfMethodCallIgnored"})
    // public void of_inferred() throws Exception
    // {
    //     callerV(Functions.of(() -> {}));
    //     callerV(Functions.of(() -> TestHelpers.returnV()));
    //     callerV(Functions.of(() -> TestHelpers.returnR()).asAction());
    //     callerV(Functions.of(() -> TestHelpers.returnS()));
    //     callerV(Functions.of(() -> ""));
    //
    //     callerR(Functions.of(() -> {}));
    //     callerR(Functions.of(() -> TestHelpers.returnV()));
    //     callerR(Functions.of(() -> TestHelpers.returnR()));
    //     callerR(Functions.of(() -> TestHelpers.returnS()));
    //     callerR(Functions.of(() -> ""));
    // }

    @Test
    @SuppressWarnings("unused")
    public void of_usualCases() throws Exception
    {
        final List<String> collect = Stream.empty()
                .map(Functions.func(x -> TestHelpers.returnS()))
                .collect(Collectors.toList());
    }
}