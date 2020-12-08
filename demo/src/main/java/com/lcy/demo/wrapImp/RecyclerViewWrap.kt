package com.lcy.demo.wrapImp

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lcy.core.wrap.WrapListModel

class RecyclerViewWrap(private val recyclerView: RecyclerView) :
    WrapListModel<RecyclerView>(recyclerView) {


    /**
     * 加载更多触发方法
     * @param waitLoadMoreItem 判断到底部多少项开始加载下一页
     */
    override fun init(waitLoadMoreItem: Int) {
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
                                loadMore()
                            }
                        }
                    }
                }
            }
        })
    }


    /**
     * 控制是否还有下一页（根据数据）
     */
    override fun checkMore(): Boolean {
        return true
    }


    /**
     * 加载下一页
     */
    override fun loadMore() {
        super.loadMore()
    }


}