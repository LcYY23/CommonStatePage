package com.lcy.demo.wrapImp

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lcy.core.wrap.WrapListModel

class RecyclerViewWrap(private val recyclerView: RecyclerView) :
    WrapListModel<RecyclerView>(recyclerView) {


    override fun setState() {

    }

    /**
     * 加载更多触发方法
     * @param waitLoadMoreItem 判断到底部多少项开始加载下一页
     */
    override fun initScrollingEvent(waitLoadMoreItem: Int) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val manager = recyclerView.layoutManager
                when (manager) {
                    is LinearLayoutManager -> {

                        val last = manager.findLastVisibleItemPosition()
                        val total = recyclerView.adapter?.itemCount ?: 0
                        if (last > 0 && last >= total - waitLoadMoreItem) {
                            if (checkMore()) {
                                preLoadMore()
                            }
                        }

                    }
                }
            }
        })
    }


    /**
     * 是否还有下一页
     */
    override fun checkMore(): Boolean {
//        if (mHasMore && !isLoading) {
//
//        }
        return false
    }


    /**
     * 准备下一页
     */
    override fun preLoadMore() {
//        pageNumber++
    }


}