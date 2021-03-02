package com.example.firstrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MyAdapter.Listener {

    private val names = listOf("Pepito Ramírez", "Camila Alzate", "Gonzalo Gutierrez", "Ana Maldonado")

    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        setupRecyclerView(recyclerView)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        myAdapter = MyAdapter(this)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        myAdapter.setData(names)
    }

    override fun onItemClicked(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }
}