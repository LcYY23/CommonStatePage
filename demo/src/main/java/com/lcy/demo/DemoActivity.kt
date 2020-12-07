package com.lcy.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.lcy.core.ListConfigBuilder
import com.lcy.core.ListLoadHelper
import com.lcy.core.LoadActionListener
import com.lcy.core.wrap.WrapRefreshModel
import com.lcy.demo.wrapImp.RecyclerViewWrap
import com.lcy.demo.wrapImp.SwipeRefreshModel

class DemoActivity : AppCompatActivity() {

    private val helper = ListLoadHelper<RecyclerView, SwipeRefreshLayout>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_list)


        val rc = findViewById<RecyclerView>(R.id.rc)
        val sw = findViewById<SwipeRefreshLayout>(R.id.sw)


        rc.layoutManager = LinearLayoutManager(this)
        val adapter = DemoListAdapter(this)
        rc.adapter = adapter
        adapter.setData(gerData())


        //方案1
        val configBuilder = ListConfigBuilder.newBuilder<RecyclerView, SwipeRefreshLayout>()
            .setListView(RecyclerViewWrap(rc))
            .setRefreshView(SwipeRefreshModel(sw))
            .setNumber(10)
            .setPage(1)

        helper.init(configBuilder, object : LoadActionListener<RecyclerView, SwipeRefreshLayout> {

            override fun firstLoad() {
                adapter.setData(gerData())
            }

            override fun refresh(refreshModel: WrapRefreshModel<SwipeRefreshLayout>) {
                refreshModel.getView().isRefreshing = false


            }

            override fun loadMore() {

            }

            override fun error() {

            }

            override fun empty() {

            }
        })


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