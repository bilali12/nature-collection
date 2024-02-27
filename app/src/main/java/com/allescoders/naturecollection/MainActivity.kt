package com.allescoders.naturecollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.allescoders.naturecollection.dao.PlantDAO
import com.allescoders.naturecollection.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = PlantDAO()
        dao.updateData {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, HomeFragment(this))
            transaction.addToBackStack(null)
            transaction.commit()
        }


    }
}