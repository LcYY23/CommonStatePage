package com.lcy.core

enum class LoadState {
    //加载中
    STATE_LOADING,

    //刷新
    STATE_REFRESH,

    //加载更多
    STATE_LOAD_MORE,

    //加载错误
    STATE_LOAD_ERROR,

    //普通状态
    STATE_COMMON
}