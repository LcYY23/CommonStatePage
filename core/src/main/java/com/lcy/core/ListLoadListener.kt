package com.lcy.core

interface LoadActionListener {
    fun firstLoad()
    fun loadMore()
    fun refresh()
    fun error()
    fun empty()
}
