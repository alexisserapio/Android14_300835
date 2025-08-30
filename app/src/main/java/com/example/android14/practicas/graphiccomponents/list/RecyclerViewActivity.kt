package com.example.android14.practicas.graphiccomponents.list

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android14.R

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val list = findViewById<RecyclerView>(R.id.list)

        //Colección de datos
        val data = listOf(AnimalEntity("Leon", "Amarillo", ""),
            AnimalEntity("Tigre", "Naranja", ""),
            AnimalEntity("Perro", "Café", ""),
            AnimalEntity("Gato", "Blanquito", ""),
            AnimalEntity("Leon", "Amarillo", ""),
            AnimalEntity("Leon", "Amarillo", ""),
            AnimalEntity("Leon", "Amarillo", ""),
            AnimalEntity("Leon", "Amarillo", ""),
            AnimalEntity("Leon", "Amarillo", ""),
            AnimalEntity("Leon", "Amarillo", "")
            )

        val adapter = AnimalAdapter(data)
        adapter.onItemSelected = {
            Toast.makeText(this, "Item selected: ${it.name}", Toast.LENGTH_SHORT).show()
        }
        list.adapter = adapter
        list.layoutManager = GridLayoutManager(this, 2)
       //list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}