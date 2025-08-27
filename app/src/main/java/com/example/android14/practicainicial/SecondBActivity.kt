package com.example.android14.practicainicial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R
import com.example.android14.practicas.explicitintent.Person

class SecondBActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_bactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvB = findViewById<TextView>(R.id.tvB)
        var infoB = ""

        val name = intent.getStringExtra("EXTRA_NAME_KEY")
        val age = intent.getIntExtra("EXTRA_AGE_KEY", 0)
        val phone = intent.getStringExtra("EXTRA_PHONE_KEY")
        val bundle = intent.getBundleExtra("EXTRA_BUNDLE_KEY")

        val surname = bundle?.getString("EXTRA_SURNAME_KEY")
        val email = bundle?.getString("EXTRA_EMAIL_KEY")
        val isMarried = bundle?.getBoolean("EXTRA_IS_MARRIED_KEY", false)



        infoB += ", ${name ?: ""}, ${surname ?: ""} $age, ${phone ?: ""}, ${email ?: ""}, ${isMarried ?: false}"

        tvB.text = infoB

        val btnReturnResult = findViewById<Button>(R.id.btnReturnB)

        btnReturnResult.setOnClickListener {

            val person1 = PersonB("Fabian", 23, false,"5555555555","example@.com")

            val resultIntent = Intent().apply {
                putExtra("EXTRA_BOOLEAN_KEY", true)
                putExtra("EXTRA_PERSON_KEY", person1)
            }
            setResult(RESULT_OK,resultIntent)
            finish()
        }


    }
}