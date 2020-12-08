package com.lcy.core.wrap

import com.lcy.core.listener.ListViewListener


open class WrapListModel<T>(t: T) : ListViewListener {


    /**
     * 加载更多触发方法
     * @param判断到底部多少项开始加载下一页
     */
    override fun init(waitLoadMoreItem: Int) {

    }

    override fun loadMore() {
        mListener?.loadMore()
    }


    /**
     * 是否还有下一页
     */
    override fun checkMore(): Boolean {
        return false
    }


    var mListener: WrapListModelListener<T>? = null
    fun setListener(listener: WrapListModelListener<T>?) {
        mListener = listener
    }


    interface WrapListModelListener<T> {
        fun loadMore()
    }


}