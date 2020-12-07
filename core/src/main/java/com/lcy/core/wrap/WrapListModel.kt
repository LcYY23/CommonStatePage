package com.lcy.core.wrap

import com.lcy.core.LoadActionListener
import com.lcy.core.listener.ListViewListener


open class WrapListModel<T>(t: T) : ListViewListener {


    override fun setState() {}

    /**
     * 加载更多触发方法
     * @param判断到底部多少项开始加载下一页
     */
    override fun initScrollingEvent(waitLoadMoreItem: Int) {}


    /**
     * 是否还有下一页
     */
    override fun checkMore(): Boolean {
        return false
    }


    /**
     * 准备下一页
     */
    override fun preLoadMore() {}


    var mListener: LoadActionListener? = null
    fun setListener(listener: LoadActionListener?) {
        mListener = listener
    }


}