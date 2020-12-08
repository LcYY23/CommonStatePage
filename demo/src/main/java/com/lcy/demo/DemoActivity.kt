package com.lcy.demo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
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

        val btnEmpty = findViewById<Button>(R.id.btnEmpty)
        val btnError = findViewById<Button>(R.id.btnError)

        val tvEmpty = findViewById<TextView>(R.id.tvEmpty)
        val tvError = findViewById<TextView>(R.id.tvError)


        rc.layoutManager = LinearLayoutManager(this)
        val adapter = DemoListAdapter(this)
        rc.adapter = adapter
        adapter.setData(firstLoadData())


        //方案1
        val configBuilder = ListConfigBuilder.newBuilder<RecyclerView, SwipeRefreshLayout>()
            .setListView(RecyclerViewWrap(rc))
            .setRefreshView(SwipeRefreshModel(sw))
            .setNumber(10)
            .setPage(1)

        helper.init(configBuilder, object : LoadActionListener<RecyclerView, SwipeRefreshLayout> {

            override fun firstLoad() {
                adapter.setData(firstLoadData())
            }

            override fun loadMore() {
                adapter.setLoadMore(loadMoreData())
            }

            override fun refresh() {
                adapter.setData(firstLoadData())
                helper.stopRefresh()  //根据获取数据状态设置停止刷新
            }

            override fun error() {
                rc.visibility = View.GONE
                tvError.visibility = View.VISIBLE
            }

            override fun empty() {
                rc.visibility = View.GONE
                tvEmpty.visibility = View.VISIBLE
            }

            override fun commonState() {
                rc.visibility = View.VISIBLE
                tvEmpty.visibility = View.GONE
                tvError.visibility = View.GONE
            }
        })

        //模拟数据为空
        btnEmpty.setOnClickListener {
            helper.setEmptyState()
        }
        //模拟请求失败
        btnError.setOnClickListener {
            helper.setErrorState()
        }
    }


    private fun firstLoadData(): ArrayList<String> {
        val list = ArrayList<String>()
        for (i in 0 until 50) {
            list.add(i.toString())
        }
        return list
    }

    private fun loadMoreData(): ArrayList<String> {
        val list = ArrayList<String>()
        for (i in 0 until 20) {
            list.add(i.toString())
        }
        return list
    }


    override fun onDestroy() {
        super.onDestroy()
    }

}