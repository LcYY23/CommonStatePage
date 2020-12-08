package com.lcy.demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DemoListAdapter(private val context: Context) : RecyclerView.Adapter<DemoListAdapter.ViewHolder>() {

    private val list = ArrayList<String>()

    fun setData(l: ArrayList<String>) {
        list.clear()
        list.addAll(l)
        notifyDataSetChanged()
    }

    fun setLoadMore(l: ArrayList<String>) {
        list.addAll(l)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_demo_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv: TextView = itemView.findViewById<TextView>(R.id.tvName)
    }
}