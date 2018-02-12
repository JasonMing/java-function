/**
 * 将有异常抛出声明的${func.type}转换为无异常抛出声明的${func.type}，异常将由{@code wrapper}包装后再抛出。
 *
 * @param wrapper 异常包装器
 *
 * @return 无异常抛出声明的${func.type}
 *
 * @apiNote <code>${func.retype} invoke(${func.params.name}) <b>${func.throws}</b></code> &#8658; <code>${func.retype} invoke(${func.params.name})</code>
 */
@SuppressWarnings("unchecked")
default ${func.propagate.type.java}<${func.propagate.params.type}> propagate(final Function1<? super X, ? extends RuntimeException> wrapper)
{
    return (${func.params.name}) ->
    {
        try
        {
            ${func.propagate.return}this.invoke(${func.params.name});
        } catch (final Throwable e)
        {
            throw wrapper.invoke((X)e);
        }
    };
}