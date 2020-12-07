package com.lcy.core.wrap

import com.lcy.core.listener.RefreshViewListener

open class WrapRefreshModel<K>(val k: K) : RefreshViewListener {

    override fun initRefresh() {

    }


    var mListener: WrapRefreshModelListener<K>? = null
    fun setListener(listener: WrapRefreshModelListener<K>?) {
        mListener = listener
    }



    fun getView(): K {
        return k
    }

    interface WrapRefreshModelListener<K> {

        fun refresh(swipeRefreshModel: WrapRefreshModel<K>)

    }
}