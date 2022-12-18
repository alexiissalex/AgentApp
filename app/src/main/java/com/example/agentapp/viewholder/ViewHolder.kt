package com.example.agentapp.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agentapp.R

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tv_condo_name = itemView.findViewById<TextView>(R.id.tv_condo_name)
    var tv_condo_busy = itemView.findViewById<TextView>(R.id.tv_condo_busy)
    var tv_condo_available = itemView.findViewById<TextView>(R.id.tv_condo_available)
}