package com.example.agentapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agentapp.R
import com.example.agentapp.model.rv_data
import com.example.agentapp.viewholder.ViewHolder

class adt_rv(val data: List<rv_data>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rv_row = LayoutInflater.from(parent.context).inflate(R.layout.rv_row,parent,false)
        val holder = ViewHolder(rv_row)
        return  holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            tv_condo_name.text = data[position].name
            tv_condo_busy.text = data[position].busy
            tv_condo_available.text = data[position].Available
        }
    }

    override fun getItemCount(): Int = data.size

}