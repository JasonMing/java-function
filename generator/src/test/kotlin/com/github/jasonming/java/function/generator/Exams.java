package com.github.jasonming.java.function.generator;

/**
 * @author JasonMing
 * @version 1.0.0
 * @since 1.0.0 (2018-02-10)
 */
public class Exams
{
    /*
     *  下述case验证了如下结论：
     *
     *  1. 重载中包含父子关系，类型判定系统使用"子类型优先"策略，如果匹配的"子类型"有多个则无法自动选择
     *  2. 一个参数以上的函数接口不能使用异常/无异常重载，否则将不能识别重载
     *  3. 通过block方式总能得到正确的重载判定
     *  4. Func extends Action 好处最多
     */
    public static void main(String[] args)
    {
        final Object o = new Object();

        // 字面值"<literal>"与"return <expression>"等价，总能匹配带有返回值的类型
        n(() -> "");
        n(() -> 1);
        n(() -> o);

        // 无参数的lambda表达式，总能按返回值类型进行匹配
        n(() -> func());
        n(() -> action());

        // 抛出异常的扩展不抛出异常的，确保方法重载能正确选中抛出异常的"特例"
        // 注意：重载了支持异常的类型后，上述所有调用都选中可抛出异常的重载，其它重载均被覆盖
        n(() -> exAction());
        n(() -> action());
        n(() -> exFunc());
        n(() -> func());

        // --------- 0与1的分割线 ---------

        // 字面值"<literal>"与"return <expression>"等价，总能匹配带有返回值的类型
        n(x -> "");
        n(x -> 1);
        n(x -> o);

        // (Func extends Action) 有参数的lambda表达式，总会使用"更具体的类型"的重载，此处为Func，正常识别有返回值的表达式（<expression>），
        n(x -> func());         // 正确选择了Func重载
        n(x -> x.toString());   // 正确选择了Func重载
        n(x -> { action(); });    // 无法识别void作为返回值，需要通过block形式强制指定

        // 注意：一个参数以上的不能使用异常/无异常重载，否则将不能识别重载
        // n(x -> exAction());
        // n(x -> action());

        // =======================================================

        // 字面值"<literal>"与"return <expression>"等价，总能匹配带有返回值的类型
        r(() -> "");
        r(() -> 1);
        r(() -> o);

        // 无参数的lambda表达式，总能按返回值类型进行匹配
        r(() -> func());
        r(() -> action());

        // 抛出异常的扩展不抛出异常的，确保方法重载能正确选中抛出异常的"特例"
        // 注意：重载了支持异常的类型后，上述所有调用都选中可抛出异常的重载，其它重载均被覆盖
        r(() -> exAction());
        r(() -> action());

        // --------- 0与1的分割线 ---------

        // 字面值"<literal>"与"return <expression>"等价，总能匹配带有返回值的类型
        r(x -> "");
        r(x -> 1);
        r(x -> o);

        // (Action extends Func) 有参数的lambda表达式，总会使用"更具体的类型"的重载，此处为Action，不能正常识别有返回值的表达式（<expression>），
        r(x -> func());             // 此处选择了Action重载
        r(x -> x.toString());       // 此处选择了Action重载
        r(x -> { return func(); });   // 通过block形式限定了使用有返回值的Func重载
        r(x -> action());

        // 注意：一个参数以上的不能使用异常/无异常重载，否则将不能识别重载
        // r(x -> exAction());
        // r(x -> action());

        // =======================================================

        // 字面值"<literal>"与"return <expression>"等价，总能匹配带有返回值的类型
        u(() -> "");
        u(() -> 1);
        u(() -> o);

        // 无参数的lambda表达式，总能按返回值类型进行匹配
        u(() -> func());
        u(() -> action());

        // 抛出异常的扩展不抛出异常的，确保方法重载能正确选中抛出异常的"特例"
        u(() -> exAction());
        u(() -> action());

        // --------- 0与1的分割线 ---------

        // 字面值"<literal>"与"return <expression>"等价，总能匹配带有返回值的类型
        u(x -> "");
        u(x -> 1);
        u(x -> o);

        // (Action 无关 Func) 有参数的lambda表达式，无法确定使用具体的重载类型（R or void）
        // u(x -> func());
        // u(x -> x.toString());
        u(x -> { return func(); });   // 通过block形式限定了使用有返回值的Func重载
        // u(x -> action());
        u(x -> { action(); });   // 通过block形式限定了使用有返回值的Func重载

        // 注意：一个参数以上的不能使用异常/无异常重载，否则将不能识别重载
        // u(x -> exAction());
        // u(x -> action());
    }

    // ===========================================================

    private static void action()
    {
        throw new RuntimeException();
    }

    private static String func()
    {
        throw new RuntimeException();
    }

    private static <R> R funcG()
    {
        throw new RuntimeException();
    }

    private static void exAction() throws Exception
    {
        throw new Exception();
    }

    private static String exFunc() throws Exception
    {
        throw new Exception();
    }

    private static <R> R exFuncG() throws Exception
    {
        throw new Exception();
    }

    // ===========================================================

    public static <R> R n(NFunc0<R> f)
    {
        return f.invoke();
    }

    public static <R> R n(NFuncX0<R, ?> f)
    {
        return f.invoke();
    }

    public static void n(NAction0 f)
    {
        f.invokeV();
    }

    public static void n(NActionX0<?> f)
    {
        f.invokeV();
    }

    // --------- 0与1的分割线 ---------

    public static <P1, R> R n(NFunc1<P1, R> f)
    {
        return f.invoke(null);
    }

    // public static <P1, R> R n(NFuncX1<P1, R, ?> f)
    // {
    //     return f.invoke(null);
    // }

    public static <P1> void n(NAction1<P1> f)
    {
        f.invokeV(null);
    }

    // public static <P1> void n(NActionX1<P1, ?> f)
    // {
    //     f.invokeV(null);
    // }

    // ===========================================================

    public static <R> R r(RFunc0<R> f)
    {
        return f.invoke();
    }

    public static <R> R r(RFuncX0<R, ?> f)
    {
        return f.invoke();
    }

    public static void r(RAction0 f)
    {
        f.invoke();
    }

    public static void r(RActionX0<?> f)
    {
        f.invoke();
    }

    // --------- 0与1的分割线 ---------

    public static <P1, R> R r(RFunc1<P1, R> f)
    {
        return f.invoke(null);
    }

    public static <P1> void r(RAction1<P1> f)
    {
        f.invokeV(null);
    }

    // ===========================================================

    public static <R> R u(UFunc0<R> f)
    {
        return f.invoke();
    }

    public static <R> R u(UFuncX0<R, ?> f)
    {
        return f.invoke();
    }

    public static void u(UAction0 f)
    {
        f.invoke();
    }

    public static void u(UActionX0<?> f)
    {
        f.invoke();
    }

    // --------- 0与1的分割线 ---------

    public static <P1, R> R u(UFunc1<P1, R> f)
    {
        return f.invoke(null);
    }

    public static <P1, R> R u(UFuncX1<P1, R, ?> f)
    {
        return f.invoke(null);
    }

    public static <P1> void u(UAction1<P1> f)
    {
        f.invoke(null);
    }

    public static <P1> void u(UActionX1<P1, ?> f)
    {
        f.invoke(null);
    }
}

// region: Func extends Action

interface NAction0
{
    void invokeV();
}

interface NActionX0<X extends Throwable> extends NAction0
{
    @Override
    default void invokeV()
    {
        //noinspection unchecked,RedundantCast
        ((NActionX0<RuntimeException>)this).invokeVX();
    }

    void invokeVX() throws X;
}

interface NFunc0<R> extends NAction0
{
    @Override
    default void invokeV()
    {
        this.invoke();
    }

    R invoke();
}

interface NFuncX0<R, X extends Throwable> extends NFunc0<R>, NActionX0<X>
{
    default R invoke()
    {
        //noinspection unchecked,RedundantCast
        return ((NFuncX0<R, RuntimeException>)this).invokeX();
    }

    R invokeX() throws X;

    @Override
    default void invokeV()
    {
        NFunc0.super.invokeV();
    }

    @Override
    default void invokeVX() throws X
    {
        this.invokeX();
    }
}

interface NAction1<P1>
{
    void invokeV(P1 p1);
}

interface NActionX1<P1, X extends Throwable> extends NAction1<P1>
{
    default void invokeV(P1 p1)
    {
        //noinspection unchecked,RedundantCast
        ((NActionX1<P1, RuntimeException>)this).invokeVX(p1);
    }

    void invokeVX(P1 p1) throws X;
}

interface NFunc1<P1, R> extends NAction1<P1>
{
    @Override
    default void invokeV(P1 p1)
    {
        this.invoke(p1);
    }

    R invoke(P1 p1);
}

interface NFuncX1<P1, R, X extends Throwable> extends NFunc1<P1, R>
{
    @Override
    default R invoke(P1 p1)
    {
        //noinspection unchecked,RedundantCast
        return ((NFuncX1<P1, R, RuntimeException>)this).invokeX(p1);
    }

    R invokeX(P1 p1) throws X;
}

// endregion: Func extends Action

// region: Action extends Func

interface RFunc0<R>
{
    R invoke();
}

interface RFuncX0<R, X extends Throwable> extends RFunc0<R>
{
    default R invoke()
    {
        //noinspection unchecked,RedundantCast
        return ((RFuncX0<R, RuntimeException>)this).invokeX();
    }

    R invokeX() throws X;
}

interface RAction0 extends RFunc0<Void>
{
    @Override
    default Void invoke()
    {
        this.invokeV();
        return null;
    }

    void invokeV();
}

interface RActionX0<X extends Throwable> extends RAction0
{
    @Override
    default void invokeV()
    {
        //noinspection unchecked,RedundantCast
        ((RActionX0<RuntimeException>)this).invokeVX();
    }

    void invokeVX() throws X;
}

interface RFunc1<P1, R>
{
    R invoke(P1 p1);
}

interface RAction1<P1> extends RFunc1<P1, Void>
{
    @Override
    default Void invoke(P1 p1)
    {
        this.invokeV(p1);
        return null;
    }

    void invokeV(P1 p1);
}

// endregion: Action extends Func

// region: Action no relation to Func

interface UFunc0<R>
{
    R invoke();
}

interface UFuncX0<R, X extends Throwable> extends UFunc0<R>
{
    default R invoke()
    {
        //noinspection unchecked,RedundantCast
        return ((UFuncX0<R, RuntimeException>)this).invokeX();
    }

    R invokeX() throws X;
}

interface UAction0
{
    void invoke();
}

interface UActionX0<X extends Throwable> extends UAction0
{
    @Override
    default void invoke()
    {
        //noinspection unchecked,RedundantCast
        ((RActionX0<RuntimeException>)this).invokeVX();
    }

    void invokeX() throws X;
}

interface UFunc1<P1, R>
{
    R invoke(P1 p1);
}

interface UFuncX1<P1, R, X extends Throwable> extends UFunc1<P1, R>
{
    default R invoke(P1 p1)
    {
        //noinspection unchecked,RedundantCast
        return ((UFuncX1<P1, R, RuntimeException>)this).invokeX(p1);
    }

    R invokeX(P1 p1) throws X;
}

interface UAction1<P1>
{
    void invoke(P1 p1);
}

interface UActionX1<P1, X extends Throwable> extends UAction1<P1>
{
    default void invoke(P1 p1)
    {
        //noinspection unchecked,RedundantCast
        ((UActionX1<P1, RuntimeException>)this).invokeX(p1);
    }

    void invokeX(P1 p1) throws X;
}

// endregion: Action no relation to Func
