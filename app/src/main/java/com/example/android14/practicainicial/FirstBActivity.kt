package com.example.android14.practicainicial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R
import com.example.android14.databinding.ActivityFirstBinding
import com.example.android14.practicas.explicitintent.Person
import com.example.android14.practicas.explicitintent.SecondActivity

class FirstBActivity : AppCompatActivity() {
    //Para usar binding

    private lateinit var binding: ActivityFirstBinding

    private val registerPerson = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == RESULT_OK){
            val booleanResult = result.data?.getBooleanExtra("EXTRA_BOOLEAN_KEY", false)
            val person1 = result.data?.getSerializableExtra("EXTRA_PERSON_KEY") as PersonB

            Toast.makeText(this, "RESULT_OK $booleanResult, ${person1.name}, ${person1.age},${person1.email},${person1.phone}", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "RESULT_CANCELLED", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //inflando binding
        binding = ActivityFirstBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_first_bactivity)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //val btnOpenPerson = findViewById<Button>(R.id.btnOpenActivity)
        binding.btnOpen

        binding.tvTitle.text = getString(R.string.app_name)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //supportActionBar?.title = "Primer Activity"
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.btnOpen.setOnClickListener {

            val extraBundle = Bundle().apply {
                putBoolean("EXTRA_IS_MARRIED_KEY", false)
                putString("EXTRA_SURNAME_KEY","Armenta")
                putString("EXTRA_EMAIL_KEY","example@.com")

            }

            val secondIntent = Intent(this, SecondBActivity::class.java).apply {
                putExtra("EXTRA_NAME_KEY", "Fabian")
                putExtra("EXTRA_AGE_KEY",23)
                putExtra("EXTRA_PHONE_KEY", "5578904569")
                putExtra("EXTRA_BUNDLE_KEY", extraBundle)
            }
            //startActivity(secondIntent)
            registerPerson.launch(secondIntent)
        }

        /*btnOpenPerson.setOnClickListener {

            val extraBundle = Bundle().apply {
                putBoolean("EXTRA_IS_MARRIED_KEY", false)
                putString("EXTRA_SURNAME_KEY","Armenta")
                putString("EXTRA_EMAIL_KEY","example@.com")

            }

            val secondIntent = Intent(this, SecondBActivity::class.java).apply {
                putExtra("EXTRA_NAME_KEY", "Fabian")
                putExtra("EXTRA_AGE_KEY",23)
                putExtra("EXTRA_PHONE_KEY", "5578904569")
                putExtra("EXTRA_BUNDLE_KEY", extraBundle)
            }
            //startActivity(secondIntent)
            registerPerson.launch(secondIntent)
        }*/
    }
}