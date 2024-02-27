package com.allescoders.naturecollection.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.allescoders.naturecollection.MainActivity
import com.allescoders.naturecollection.R
import com.allescoders.naturecollection.model.PlantModel
import com.bumptech.glide.Glide

class PlantAdapter(
    private val context: MainActivity,
    private val listOfPlant: List<PlantModel>,
    private val layoutId: Int) : RecyclerView.Adapter<PlantAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val plantImg = view.findViewById<ImageView>(R.id.image_item)
        val plantName: TextView? = view.findViewById(R.id.name_item)
        val plantDescription: TextView? = view.findViewById(R.id.description_item)
        val starIcon =  view.findViewById<ImageView>(R.id.unstar_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listOfPlant.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentPlant = listOfPlant[position]

        Glide.with(context).load(Uri.parse(currentPlant.imgUrl)).into(holder.plantImg)
        holder.plantName?.text =  currentPlant.name
        holder.plantDescription?.text =  currentPlant.description

        if(currentPlant.liked) {
            holder.starIcon.setImageResource(R.drawable.ic_star)
        }else {
            holder.starIcon.setImageResource(R.drawable.ic_unstar)
        }
    }
}