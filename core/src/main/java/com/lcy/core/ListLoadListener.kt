package com.lcy.core

import com.lcy.core.wrap.WrapRefreshModel

interface LoadActionListener<T, K> {
    fun firstLoad()
    fun loadMore()
    fun refresh(refreshModel: WrapRefreshModel<K>)
    fun error()
    fun empty()
}
