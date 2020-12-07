package com.lcy.demo.wrapImp

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.lcy.core.wrap.WrapRefreshModel

class SwipeRefreshModel(private val sw: SwipeRefreshLayout)
    : WrapRefreshModel<SwipeRefreshLayout>(sw) {

    override fun initRefresh() {
        sw.setOnRefreshListener {
            mListener?.refresh(this)
        }
    }
}