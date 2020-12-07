package com.lcy.core.wrap

import com.lcy.core.LoadActionListener
import com.lcy.core.listener.RefreshViewListener

open class WrapRefreshModel<K>(k: K) : RefreshViewListener {

    override fun initRefresh() {

    }


    var mListener: LoadActionListener? = null
    fun setListener(listener: LoadActionListener?) {
        mListener = listener
    }

}