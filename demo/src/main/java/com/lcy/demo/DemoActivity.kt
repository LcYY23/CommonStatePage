package com.lcy.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.lcy.core.ListConfigBuilder
import com.lcy.core.ListLoadHelper
import com.lcy.core.LoadActionListener
import com.lcy.demo.wrapImp.RecyclerViewWrap
import com.lcy.demo.wrapImp.SwipeRefreshModel

class DemoActivity : AppCompatActivity(){

    private val helper = ListLoadHelper<RecyclerView, SwipeRefreshLayout>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_list)


        //方案1
        val configBuilder = ListConfigBuilder.newBuilder<RecyclerView, SwipeRefreshLayout>()
            .setListView(RecyclerViewWrap(rc))
            .setRefreshView(SwipeRefreshModel(sw))
            .setNumber(10)
            .setPage(1)

        helper.init(configBuilder, object : LoadActionListener {

            override fun firstLoad() {

            }

            override fun refresh() {

            }

            override fun loadMore() {

            }

            override fun error() {

            }

            override fun empty() {

            }
        })

        rc.layoutManager = LinearLayoutManager(this)
        val adapter = DemoListAdapter(this)
        rc.adapter = adapter
        adapter.setData(gerData())
    }


    private fun gerData(): ArrayList<String> {
        val list = ArrayList<String>()
        for (i in 0 until 50) {
            list.add("i")
        }
        return list
    }


    override fun onDestroy() {
        super.onDestroy()
    }

}