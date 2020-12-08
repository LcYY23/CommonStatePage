package com.lcy.core


interface LoadActionListener<T, K> {
    fun firstLoad()
    fun loadMore()
    fun refresh()
    fun error()
    fun empty()
    fun commonState()
}
