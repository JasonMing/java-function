/**
 * 扩展Action的返回值到{@code <R>}使其转换为对应的Function，并使用{@code ret}作为返回值。
 *
 * @param ret 作为Function的返回值
 * @param <R> Function返回值的类型
 *
 * @return 参数个数与Action相同的Function
 *
 * @apiNote <code><b>void</b> invoke(${func.params.name}) ${func.throws}</code> &#8658; <code><b>R</b> invoke(${func.params.name}) ${func.throws}</code>
 */${annotation.override}
default <R> ${func.tofunc.type.java}<${func.tofunc.params.type}> extern(final R ret)
{
    return (${func.params.name}) ->
    {
        this.invoke(${func.params.name});
        return ret;
    };
}