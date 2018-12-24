/*
 * Copyright (c) 2018 JasonMing All Rights Reserved.
 */

package com.github.jasonming.java.function.generator

import java.io.Writer
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

private val X = object { }

private const val PACKAGE = "com.github.jasonming.java.function"

fun main(args: Array<String>)
{
    val genPath = Paths.get(X.javaClass.protectionDomain.codeSource.location.toURI()) // .../target/test-classes
        .parent // .../target
        .parent // ...
        .parent // ${project_root}
        .resolve("src/main/java") // .../src/main/java
        .resolve(PACKAGE.replace('.', '/'))
    println("mkdirs: " + genPath.toFile().mkdirs())

    if (args.firstOrNull() == "console")
    {
        generateActions().writeTo { NoCloseSoutWriter }
        generateFunctions().writeTo { NoCloseSoutWriter }
    } else
    {
        generateActions().writeTo { file(genPath, it) }
        generateFunctions().writeTo { file(genPath, it) }
    }
}

private fun Map<String, String>.writeTo(wf: (name: String) -> Writer) =
    this.forEach { k, v ->
        wf(k).use {
            // Header
            it.appendln("/*")
            it.appendln(" * GENERATED FILE: any modifications will be overridden after regenerating.")
            it.appendln(" */")
            it.appendln()

            // Body
            it.appendln("package ${PACKAGE};")
            it.appendln()
            it.write(v)
        }
    }

private fun file(basePath: Path, name: String) =
    basePath.resolve("$name.java")
        .apply { println("output: " + this) }
        .let { Files.newBufferedWriter(it, Charset.forName("UTF-8")) }

object NoCloseSoutWriter : Writer()
{

    val w = System.out.writer()

    override fun write(cbuf: CharArray?, off: Int, len: Int)
    {
        w.write(cbuf, off, len)
    }

    override fun flush()
    {
        w.flush()
    }

    override fun close()
    {
        w.flush()
    }
}