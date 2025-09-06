package com.example.android14.practicas.graphiccomponents.list

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R
import com.squareup.picasso.Picasso

class RVDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rvdetails)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //var infoReceived = ""
        val tvAnimalName = findViewById<TextView>(R.id.tvAnimalName)
        val tvAnimalColor = findViewById<TextView>(R.id.tvAnimalColor)
        val ivAnimalImage = findViewById<ImageView>(R.id.ivAnimalImage)
        intent.extras?.let { info ->
            if (info.containsKey("EXTRA_ANIMAL_KEY")){
                val animal = info.getSerializable("EXTRA_ANIMAL_KEY") as AnimalEntity
                tvAnimalName.text = animal.name
                tvAnimalColor.text = animal.color
                Picasso.get().load(animal.image)
                    .placeholder(R.drawable.img_placeholder)
                    .error(R.drawable.outline_delete_24)
                    .into(ivAnimalImage)
            }
        }

    }



}

