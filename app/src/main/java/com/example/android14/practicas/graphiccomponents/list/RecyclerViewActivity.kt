package com.example.android14.practicas.graphiccomponents.list

import android.content.Intent
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
        val data = listOf(AnimalEntity("Leon", "Amarillo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            AnimalEntity("Tigre", "Naranja", "https://imgs.search.brave.com/Utj-vReJOC2HtRkCvCc0c4XOdvWIeM4A3Rb2bTj6WD0/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZXMtbmEuc3NsLWlt/YWdlcy1hbWF6b24u/Y29tL2ltYWdlcy9J/LzYxUm00NitLNzBM/LmpwZw"),
            AnimalEntity("Perro", "Café", "https://imgs.search.brave.com/5x3RDIIrGIucFUsFqyHgoaZzjo-oDkj9lAuP88WuWGM/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTIw/NTIwMjgyL3Bob3Rv/L2RhY2hzaHVuZC1k/b2cuanBnP3M9NjEy/eDYxMiZ3PTAmaz0y/MCZjPTI2VVdlMDlT/aWRYejdKZFlQa3Z3/aHYwV2RSLURITHJz/b1ZfR19KcWQ2NWs9"),
            AnimalEntity("Gato", "Blanquito", "https://imgs.search.brave.com/63R02lNntAi0f6qxfOx17YAes-JjCUqn8nUKcLAQR88/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWcu/ZnJlZXBpay5jb20v/Zm90by1ncmF0aXMv/cHJpbWVyLXBsYW5v/LWxpbmRvLWdhdG8t/ZG9tZXN0aWNvLWJs/YW5jby1ncmlzXzE4/MTYyNC0xODc2MS5q/cGc_c2VtdD1haXNf/aXRlbXNfYm9vc3Rl/ZCZ3PTc0MA"),
            AnimalEntity("Leon", "Amarillo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            AnimalEntity("Leon", "Amarillo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            AnimalEntity("Leon", "Amarillo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            AnimalEntity("Leon", "Amarillo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            AnimalEntity("Leon", "Amarillo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            AnimalEntity("Leon", "Amarillo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU")
            )

        val adapter = AnimalAdapter(data)
        adapter.onItemSelected = {
            //Toast.makeText(this, "Item selected: ${it.name}", Toast.LENGTH_SHORT).show()
            val animalEntityIntent = Intent(this, RVDetailsActivity::class.java).apply {
                putExtra("EXTRA_ANIMAL_KEY", it)
            }
            startActivity(animalEntityIntent)

        }
        list.adapter = adapter
        list.layoutManager = GridLayoutManager(this, 1)
       //list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}