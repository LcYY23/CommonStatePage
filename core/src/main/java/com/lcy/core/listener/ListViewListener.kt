package com.lcy.core.listener


interface ListViewListener {

    fun setState()

    /**
     * 加载更多触发方法
     * @param判断到底部多少项开始加载下一页
     */
    fun initScrollingEvent(waitLoadMoreItem: Int)


    /**
     * 是否还有下一页
     */
    fun checkMore(): Boolean


    /**
     * 准备下一页
     */
    fun preLoadMore()
}