package com.lcy.core.wrap

import com.lcy.core.listener.RefreshViewListener

open class WrapRefreshModel<K>(val k: K) : RefreshViewListener {

    override fun initRefresh() {

    }
    override fun stopRefresh() {

    }


    var mListener: WrapRefreshModelListener<K>? = null
    fun setListener(listener: WrapRefreshModelListener<K>?) {
        mListener = listener
    }


    interface WrapRefreshModelListener<K> {
        fun refresh()
    }
}