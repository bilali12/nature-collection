package com.allescoders.naturecollection.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.allescoders.naturecollection.R

class PlantAdapter(private val layoutId : Int) : RecyclerView.Adapter<PlantAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val plantImg = view.findViewById<ImageView>(R.id.image_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {}
}