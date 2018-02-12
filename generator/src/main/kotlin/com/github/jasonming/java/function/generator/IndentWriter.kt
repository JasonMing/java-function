/*
 * Copyright (c) 2018 JasonMing All Rights Reserved.
 */

package com.github.jasonming.java.function.generator

import java.io.StringWriter

/**
 *
 * @author JasonMing
 * @version 1.0.0
 * @since 1.0.0 (2018-02-10)
 */
class IndentWriter : StringWriter()
{
    companion object
    {
        const val INDENT_SIZE = 4
        const val INDENT_CHAR = ' '
        private val INDENT_FILLER = { _: Int -> INDENT_CHAR }
    }

    private var indent: CharArray = CharArray(0)

    private var level: Int = 0
        set(value)
        {
            field = value
            this.indent = CharArray(value * INDENT_SIZE, INDENT_FILLER)
        }

    override fun write(c: Int)
    {
        super.write(c)
    }

    // Re-call overriden implement
    // override fun write(cbuf: CharArray?)
    // {
    //     super.write(cbuf)
    // }

    override fun write(cbuf: CharArray?, off: Int, len: Int)
    {
        this.writeIndentInternal()
        super.write(cbuf, off, len)
    }

    override fun write(str: String?)
    {
        this.writeIndentInternal()
        super.write(str)
    }

    override fun write(str: String?, off: Int, len: Int)
    {
        this.writeIndentInternal()
        super.write(str, off, len)
    }

    override fun append(csq: CharSequence?): StringWriter
    {
        if (csq?.let { it.startsWith(LINE_ENDING) || it.isEmpty() } == true)
        {
            // If line is empty, do not write indent chars.
            super.write(csq.toString())
        } else
        {
            super.append(csq)
        }
        return this
    }

    fun writeIndent(level: Int)
    {
        this.write(CharArray(level * INDENT_SIZE, INDENT_FILLER))
    }

    fun withinBlock(f: (@ParameterName("writer") IndentWriter) -> Unit)
    {
        this.appendln('{')
        this.increaseIndent()
        try
        {
            f(this)
        } finally
        {
            this.decreaseIndent()
            this.appendln('}')
        }
    }

    private fun writeIndentInternal()
    {
        super.write(this.indent, 0, this.indent.size)
    }

    fun increaseIndent(delta: Int = 1)
    {
        this.level += delta;
    }

    fun decreaseIndent(delta: Int = 1)
    {
        this.level -= minOf(this.level, delta);
    }
}

