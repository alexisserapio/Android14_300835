package com.example.android14.practicas.graphiccomponents

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R

class BasicComponentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_basic_components)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cbCredit = findViewById<CheckBox>(R.id.cbCredit)
        val btNext = findViewById<Button>(R.id.btNext)
        val rgGenre = findViewById<RadioGroup>(R.id.rgGenre)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etEmail =  findViewById<EditText>(R.id.etEmail)

        //CheckBox
        cbCredit.isChecked = true
        cbCredit.setOnCheckedChangeListener { compoundButton, isChecked -> Toast.makeText(this, "isChecked = $isChecked",Toast.LENGTH_LONG).show()

        }

        //RadioGroup
        rgGenre.setOnCheckedChangeListener { radioGroup, id ->
            val name = getRGGenreLabel(id)
            Toast.makeText(this, "isChecked = $name",Toast.LENGTH_LONG).show()

        }

        //Spiner
        val data = arrayListOf("No seleccion", "México","EUA", "Colombia","Canada","Argentina","Francia","Brasil","Venezuela","España")
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, data).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object :OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val itemSelected = data[position]
                if (position == 0){
                    Toast.makeText(this@BasicComponentsActivity,"Item no seleccionado", Toast.LENGTH_SHORT).show()
                } else{
                    Toast.makeText(this@BasicComponentsActivity,"Item seleccionado: $itemSelected", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@BasicComponentsActivity,"Nada seleccioando", Toast.LENGTH_SHORT).show()
            }

        }



        btNext.setOnClickListener {

            //Validar que ingrese contraseña para continuar

            if (etPassword.text.toString().isEmpty() || spinner.selectedItem == "No seleccion" || etEmail.text.toString().isEmpty()){

                Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_SHORT).show()
            }else{
                val cbCreditStatus = cbCredit.isChecked
                val selectedRgOption = getRGGenreLabel(rgGenre.checkedRadioButtonId)
                val itemSelected = spinner.selectedItem
                Toast.makeText(this, "isChecked = $cbCreditStatus, radioButtonSelected = $selectedRgOption, selectedSpinner = $itemSelected",Toast.LENGTH_LONG).show()
            }
        }


    }

    private fun getRGGenreLabel(id: Int): String{
        return when(id){
            R.id.rbWoman ->{ "Mujer" }
            R.id.rbMan -> { "Hombre" }
            else -> "Desconocido"
        }
    }
}