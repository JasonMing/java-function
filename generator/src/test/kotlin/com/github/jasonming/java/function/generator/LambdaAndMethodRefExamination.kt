/*
 * Copyright (c) 2018 JasonMing All Rights Reserved.
 */

package com.github.jasonming.java.function.generator

import org.junit.Test
import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KFunction1
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.full.isSuperclassOf

class LambdaAndMethodRefExamination
{
    private inline fun <reified T : Any> typeOf(): KClass<T> = T::class

    @Test
    fun test()
    {
        fun compareType(xn: String, xt: KClass<*>, yn: String, yt: KClass<*>)
        {
            println("=========================================")
            println("[$xn] <=> [${xt.qualifiedName}], [$yn] <=> [${yt.qualifiedName}]")
            println("[$xn] === [$yn]: ${xt === yt}")
            println("[$xn] sup [$yn]: ${xt.isSuperclassOf(yt)}")
            println("[$xn] ext [$yn]: ${xt.isSubclassOf(yt)}")
            println()
        }

        compareType("kotlin.Function1", kotlin.Function1::class, "(*) -> *", typeOf<(Any) -> Any>())
        compareType("kotlin.Function1", kotlin.Function1::class, "kotlin.Function", Function::class)
        compareType("kotlin.Function1", kotlin.Function1::class, "kotlin.jvm.functions.Function1", kotlin.jvm.functions.Function1::class)

        compareType("kotlin.reflect.KFunction1", kotlin.reflect.KFunction1::class, "kotlin.Function", kotlin.Function::class)
        compareType("kotlin.reflect.KFunction1", kotlin.reflect.KFunction1::class, "kotlin.reflect.KFunction", kotlin.reflect.KFunction::class)

        compareType("kotlin.reflect.KFunction1", kotlin.reflect.KFunction1::class, "kotlin.Function1", kotlin.Function1::class)
        compareType("kotlin.reflect.KFunction1", kotlin.reflect.KFunction1::class, "kotlin.jvm.functions.Function1", kotlin.jvm.functions.Function1::class)

        val lambda = { _: CharSequence -> true }
        println("lambda is Function<*>: ${lambda is Function<*>}")
        println("lambda is Function1<*>: ${lambda is Function1<*, *>}")
        println("lambda is KCallable<*>: ${lambda is KCallable<*>}")
        println("lambda is KFunction<*>: ${lambda is KFunction<*>}")
        println("lambda is KFunction1<*, *>: ${lambda is KFunction1<*, *>}")

        val methodRef = Regex::matches
        println("methodRef is Function<*>: ${methodRef is Function<*>}")
        println("methodRef is Function1<*>: ${methodRef is Function1<*, *>}")
        println("methodRef is KCallable<*>: ${methodRef is KCallable<*>}")
        println("methodRef is KFunction<*>: ${methodRef is KFunction<*>}")
        println("methodRef is KFunction1<*, *>: ${methodRef is KFunction1<*, *>}")
    }
}