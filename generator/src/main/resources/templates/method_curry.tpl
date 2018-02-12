/**
 * 绑定传入参数到此${func.type}上的第一个参数{@link P1}上，并且返回剩余参数的${func.type}。
 *
 * @param arg1 将绑定到第一个位置的参数
 *
 * @return 剩余参数的${func.type}
 *
 * @apiNote <code>${func.retype} invoke(${func.params.name}) ${func.throws}</code> &#8658; <code>${func.retype} invoke(${func.curry.params.name}) ${func.throws}</code>
 * @see <a href="https://zh.wikipedia.org/wiki/%E6%9F%AF%E9%87%8C%E5%8C%96">柯里化（Currying）</a>
 */${annotation.override}
default ${func.curry.type.java}<${func.curry.params.type}> bind(final P1 arg1)
{
    return (${func.curry.params.name}) -> this.invoke(${func.params.name});
}