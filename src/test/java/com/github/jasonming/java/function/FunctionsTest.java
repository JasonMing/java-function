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
        final Action actionBlk = Functions.of(() -> {});
        final Action actionExpV = Functions.of(() -> TestHelpers.returnV());
        final Action actionExpR = Functions.of(() -> TestHelpers.returnR());
        final Action actionExpS = Functions.of(() -> TestHelpers.returnS());
        final Func<String> func = Functions.of(() -> "");
        // final Func<String> funcExpV = Functions.of(() -> TestHelpers.returnV());
        final Func<String> funcExpR = Functions.of(() -> TestHelpers.returnR());
        final Func<String> funcExpS = Functions.of(() -> TestHelpers.returnS());

        final Action1<String> action1Blk = Functions.of(p1 -> {});
        // final Action1<String> action1ExpV = Functions.of(p1 -> TestHelpers.returnV());
        final Action1<String> action1BlkV = Functions.of(p1 -> { TestHelpers.returnV(); });
        final Action1<String> action1ExpR = Functions.of(p1 -> TestHelpers.returnR());
        final Action1<String> action1ExpS = Functions.of(p1 -> TestHelpers.returnS());
        final Func1<String, String> func1 = Functions.of(p1 -> "");
        // final Func1<String, String> func1ExpV = Functions.of(p1 -> TestHelpers.returnV());
        final Func1<String, String> func1ExpR = Functions.of(p1 -> TestHelpers.returnR());
        final Func1<String, String> func1ExpS = Functions.of(p1 -> TestHelpers.returnS());
    }

    private static void callerV(final Runnable f) { }
    // Could not overload between Action and Func, otherwise, the non-void expression not be recognized.
    // private static void callerV(final Supplier<?> f) { }

    private static <R> R callerR(final Runnable f) { return null; }
    // Could not overload between Action and Func, otherwise, the non-void expression not be recognized.
    // private static <R> R callerR(final Supplier<R> f) { return null; }

    @Test
    @SuppressWarnings({"unused", "ResultOfMethodCallIgnored"})
    public void of_inferred() throws Exception
    {
        callerV(Functions.of(() -> {}));
        callerV(Functions.of(() -> TestHelpers.returnV()));
        callerV(Functions.of(() -> TestHelpers.returnR()));
        callerV(Functions.of(() -> TestHelpers.returnS()));
        callerV(Functions.of(() -> ""));

        callerR(Functions.of(() -> {}));
        callerR(Functions.of(() -> TestHelpers.returnV()));
        callerR(Functions.of(() -> TestHelpers.returnR()));
        callerR(Functions.of(() -> TestHelpers.returnS()));
        callerR(Functions.of(() -> ""));
    }

    @Test
    @SuppressWarnings("unused")
    public void of_usualCases() throws Exception
    {
        final List<String> collect = Stream.empty()
                .map(Functions.of(x -> TestHelpers.returnS()))
                .collect(Collectors.toList());
    }
}