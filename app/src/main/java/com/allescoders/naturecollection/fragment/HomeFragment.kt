package com.allescoders.naturecollection.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.allescoders.naturecollection.R
import com.allescoders.naturecollection.adapter.PlantAdapter
import com.allescoders.naturecollection.adapter.PlantItemDecoration

class HomeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val horizontalRecyclerView = view?.findViewById<RecyclerView>(R.id.horizontal_reclycler_view)
        horizontalRecyclerView?.adapter = PlantAdapter(R.layout.item_horizontal_plant)

        val verticalRecyclerView = view?.findViewById<RecyclerView>(R.id.vertical_reclycler_view)
        verticalRecyclerView?.adapter = PlantAdapter(R.layout.item_vertical_plant)
        verticalRecyclerView?.addItemDecoration(PlantItemDecoration())
        return view
    }
}