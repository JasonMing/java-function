package ${func.package};

/**
 * 提供一个<b>有参</b>、<b>返回{@link R}</b>、<b>无异常声明</b>的{@linkplain FunctionalInterface 函数式接口}。<br>
 * 任何低于JDK1.8的项目都引用此接口均会产生编译器错误。
 *
 * @author JasonMing
 * @version 1.0.0
 * @since 1.0.0 (2018-02-10)
 *
 * @see FunctionalInterface
 */
@FunctionalInterface
public interface ${func.type.java}<${func.params.type.declare}>
{
#{method.invoke}

#{method.curry}

#{method.uncurry}
}
