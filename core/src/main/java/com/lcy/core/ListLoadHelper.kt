package com.lcy.core

import com.lcy.core.wrap.WrapListModel
import com.lcy.core.wrap.WrapRefreshModel


/**
 * 刷新控件：
 * SwipeRefreshLayout
 * SmartRefresh
 * ...
 *
 * 列表控件
 * ListView
 * RecyclerView
 *
 */
class ListLoadHelper<T, K> {


    //列表包装类
    private var mWrapListModel: WrapListModel<T>? = null

    //刷新包装类
    private var mWrapRefreshModel: WrapRefreshModel<K>? = null


    //待定
    private var page: Int = 0;

    //待定
    private var number: Int = 0;


    private var listener: LoadActionListener<T, K>? = null

    fun init(config: ListConfigBuilder<T, K>, l: LoadActionListener<T, K>) {
        page = config.getPage()
        number = config.getNumber()
        mWrapListModel = config.getListView()
        mWrapRefreshModel = config.getRefreshView()
        listener = l

        mWrapListModel?.init(5)
        mWrapListModel?.setListener(object : WrapListModel.WrapListModelListener<T> {
            override fun loadMore() {
                listener?.loadMore()
            }
        })

        mWrapRefreshModel?.setListener(object : WrapRefreshModel.WrapRefreshModelListener<K> {
            override fun refresh() {
                setCommonState()
                listener?.refresh()
            }
        })

        mWrapRefreshModel?.initRefresh()
    }


    fun stopRefresh() {
        mWrapRefreshModel?.stopRefresh()
    }


    fun setErrorState() {
        listener?.error()
    }


    fun setEmptyState() {
        listener?.empty()
    }


    fun setCommonState() {
        listener?.commonState()
    }
}