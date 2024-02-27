package com.allescoders.naturecollection.dao

import com.allescoders.naturecollection.dao.PlantDAO.Singleton.dbRef
import com.allescoders.naturecollection.dao.PlantDAO.Singleton.listOfPlant
import com.allescoders.naturecollection.model.PlantModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PlantDAO {
    object Singleton {
        //se connecter a la reference
        val dbRef = FirebaseDatabase.getInstance().getReference("plants")

        //creattion d'une liste qui va contenir les plantes
        val listOfPlant = arrayListOf<PlantModel>()
    }

    fun updateData(callback: () -> Unit ) {
        //lire les données a partir de la bd
        dbRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                listOfPlant.clear()
                for(item in snapshot.children) {
                    val plant = item.getValue(PlantModel::class.java)

                    if(plant != null) {
                        listOfPlant.add(plant)
                    }
                }
                println(listOfPlant.size)
                callback()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}