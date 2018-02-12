# Java SAM Function Extensions

## 目标

扩展`java.util.function`下的SAM Function功能。

## 简述

### 模型

![](docs/JavaFunctions_Design.png)

### 命名规则

由于Java不支持泛型重载，所以对所有函数式接口采用以下命名规则：

> 函数类别 + 异常标识 + 参数个数

- 函数类别

  主要分为`Func`与`Action`，`Func`有返回值，`Action`无返回值（void）。

- 异常标识

  | 标识 | 描述 |
  | ---- | ---- |
  | ` `（*无标识*） | 对应方法不能抛出异常 |
  | `E` | 对应方法可以抛出任意`Exception` |
  | `X` | 可通过泛型参数`X`指定具体类型的异常 |

- 参数个数

  当前支持0～个入参，0个参数（无参）时后缀不加`0`。

### 主要类型

| 接口 | 返回 | 抛出 |
| ---- | ---- | ---- |
| Action | `void` | 无 |
| ActionE | `void` | `Exception` |
| ActionX | `void` | `X`（任意指定类型） |
| Func | `R` | 无 |
| FuncE | `R` | `Exception` |
| FuncX | `R` | `X`（任意指定类型） |

### `java.util.function`兼容

## 特性

### Partial apply（部分参数应用）

只应用部分参数并返回剩余参数的Function

```java
public static void main(String[] args)
{
    final Func3<Integer, Integer, Integer, Boolean> f3 = (p1, p2, p3) -> (p1 + p2 + p3) % 2 == 0;
    
    final Func2<Integer, Integer, Boolean>          f2 = f3.apply(3);
    final Func1<Integer, Boolean>                   f1 = f2.apply(13);
    
    f1.invoke(4); // (3 + 13 + 4) % 2 = 0 => true
    f1.invoke(7); // (3 + 13 + 7) % 2 = 1 => false
}
```

### 可抛出异常的方法

java标准库里所有的函数式接口均不能抛出异常，一旦使用到抛出检查型异常（checked exception）的方法时，就无可避免地进行try-catch-rethrow的操作，不但繁琐，而且很有可能误吞异常。

使用名称中带有`X`或`E`的函数式接口（如：`FuncX`/`ActionE`）即可简单地通过声明形式将异常向外传播，而无需进行手动处理。

```java
static String readSomething() throws IOException { ... }

public static void main(final String[] args)
{
    // 使用标准库的Supplier<T>，异常声明不兼容
    final Supplier<String> error = () -> readSomething(); // error: "Unhandled exception: IOException"

    // 使用标准库的Supplier<T>，包装并重抛出异常
    final Supplier<String> supplier = () ->
    {
        try
        {
            return readSomething();
        } catch (final IOException e)
        {
            // 必须重新包装为非检查型异常（unchecked exception)抛出，或自行处理异常。
            throw new RuntimeException(e);
        }
    };
    
    // 使用FuncX<R, X>，异常直接向外传播
    final FuncX<String, IOException> funcX = () -> readSomething();
    
    // 如果不关注异常类型，可直接使用FuncE<R>
    final FuncE<String> funcE = () -> readSomething();
}
```

### 传播异常

在上述例子[可抛出异常的方法](#可抛出异常的方法)中，可以使用`FuncE<R>`或`FuncX<R, X>`调用抛出检查型异常（checked exception）的方法而无需进行额外的异常处理。

但大部分时候，标准库中使用的是无异常声明的`Supplier<T>`或`Function<T, R>`，但执行过程中很多时候明知异常是需要抛出到上一级进行处理，但由于方法声明的限制，我们必须通过`RuntimeException`（或其子类）重新包装后再抛出，使用起来甚是不便。

```java

// 抛出检查型异常的方法
static Map<String, ?> readJsonWithException(String source) throws IOException { ... }

public static void main(String[] args)
{
    final List<String> source = new ArrayList();

    source.stream()
          .map(x -> readJsonWithException(x)) // 编译错误：Unhandled exception
          .collect(Collectors.toList());

    // 因为map()使用的是java.util.function.Function<T,R>，其方法签名为：
    // `R apply(T t);`，不可抛出任何检查型异常
    // 所以，直接调用`readJson()`方法时会提示编译错误："Unhandled exception"
    // 此时就必须手动捕获异常，但大多数情况下均无法处理异常，此时就需要使用非检查型异常进行包装后从新抛出。

    source.stream()
          .map(x ->
          {
              try
              {
                  return readJsonWithException(x);
              } catch(IOException e)
              {
                  throw new RuntimeException(e);
              }
          })
          .collect(Collectors.toList());
}
```

此时我们可以使用`Functions.propagate()`方法，生成一个可正常传播异常但方法上不声明抛出的`Action`/`Func`

```java
static Map<String, ?> readJson(String source) throws IOException { ... }

public static void main(String[] args)
{
    final List<String> source = new ArrayList();

    // 使用Functions.propagate()对外传播异常
    source.stream()
          .map(Functions.propagate(x -> readJson(x)))
          .collect(Collectors.toList());
}

```

### 柯里化

通过***Partial apply（部分参数应用）*** 实现部分柯里化。
