package com.lcy.core

import com.lcy.core.wrap.WrapListModel
import com.lcy.core.wrap.WrapRefreshModel

class ListConfigBuilder<T, K> {

    companion object {
        fun <T, K> newBuilder(): ListConfigBuilder<T, K> {
            return ListConfigBuilder()
        }
    }

    //列表包装类
    private var mWrapListModel: WrapListModel<T>? = null

    //刷新包装类
    private var mWrapRefreshModel: WrapRefreshModel<K>? = null


    //不一定会有
    private var page: Int = 0;

    private var number: Int = 0;


    fun setListView(wrap: WrapListModel<T>): ListConfigBuilder<T, K> {
        mWrapListModel = wrap
        return this
    }

    fun setRefreshView(wrap: WrapRefreshModel<K>): ListConfigBuilder<T, K> {
        mWrapRefreshModel = wrap
        return this
    }


    fun setPage(p: Int): ListConfigBuilder<T, K> {
        page = p
        return this
    }


    fun setNumber(n: Int): ListConfigBuilder<T, K> {
        number = n
        return this
    }


    fun getListView(): WrapListModel<T>? {
        return mWrapListModel
    }


    fun getRefreshView(): WrapRefreshModel<K>? {
        return mWrapRefreshModel
    }

    fun getPage(): Int {
        return page
    }

    fun getNumber(): Int {
        return number
    }

}