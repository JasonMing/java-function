/**
 * 扩展${func.type}最后一个位置的参数，使其匹配更多参数的${func.type}。
 *
 * @return 比当前${func.type}多一个参数的${func.type}
 *
 * @apiNote <code>${func.retype} invoke(${func.params.name}) ${func.throws}</code> &#8658; <code>${func.retype} invoke(${func.uncurry.params.name}) ${func.throws}</code>
 */${annotation.override}
default <${func.uncurry.params.type.last}> ${func.uncurry.type.java}<${func.uncurry.params.type}> extern()
{
    return (${func.uncurry.params.name}) -> this.invoke(${func.params.name});
}