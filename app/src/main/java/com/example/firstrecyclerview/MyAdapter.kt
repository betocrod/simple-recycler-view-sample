package com.example.firstrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private val listener: Listener
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    interface Listener {

        fun onItemClicked(name: String)
    }

    private var data: List<String> = emptyList()

    fun setData(names: List<String>) {
        this.data = names
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setIndex(position)
        holder.setName(data[position])
        holder.setListener(listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        
        private var name: String? = null

        fun setIndex(index: Int) {
            itemView.findViewById<TextView>(R.id.textView_index).text = "$index."
        }

        fun setName(name: String) {
            this.name = name
            itemView.findViewById<TextView>(R.id.textView_name).text = name
        }
        
        fun setListener(listener: Listener) {
            itemView.setOnClickListener { 
                name?.let { listener.onItemClicked(it)  }
            }
        }
    }
}
