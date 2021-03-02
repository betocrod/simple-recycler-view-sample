package com.example.firstrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var data: List<String> = emptyList()

    fun setData(names: List<String>) {
        this.data = names
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setIndex(position)
        holder.setName(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun setIndex(index: Int) {
            itemView.findViewById<TextView>(R.id.textView_index).text = index.toString()
        }

        fun setName(name: String) {
            itemView.findViewById<TextView>(R.id.textView_name).text = name
        }
    }
}
