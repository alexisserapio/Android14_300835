package com.example.android14.practicas.explicitintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvInfo = findViewById<TextView>(R.id.tvInfo)
        var infoReceived = ""
        intent.extras?.let { info ->

            if (info.containsKey("EXTRA_NAME_KEY")){
                infoReceived += info.getString("EXTRA_NAME_KEY", "")
            }

            if (info.containsKey("EXTRA_AGE_KEY")){
                infoReceived += ", " + info.getInt("EXTRA_AGE_KEY", 0)
            }

            if (info.containsKey("EXTRA_BUNDLE_KEY")){
                val bundle = info.getBundle("EXTRA_BUNDLE_KEY")
                bundle?.let {
                   infoReceived +=  ", " + bundle.getString("EXTRA_SURNAME_KEY", "")
                    infoReceived +=  ", " + bundle.getBoolean("EXTRA_IS_MARRIED_KEY", false)
                }

            }
        }

        //Second tenemos que validar que no es nula

        val name = intent.getStringExtra("EXTRA_NAME_KEY")
        val age = intent.getIntExtra("EXTRA_AGE_KEY", 0)

//        name?.let {
//            infoReceived += ", " + it
//            infoReceived += ", $it"
//        }

        //infoReceived += ", $age"
        //infoReceived += ", ${if (name != null) name else ""}, $age"
        infoReceived += ", ${name ?: ""}, $age"



        tvInfo.text = infoReceived

        val btnReturnResult = findViewById<Button>(R.id.btnReturnResult)

        btnReturnResult.setOnClickListener {

            val person1 = Person("Fabian", 23, false)

            val resultIntent = Intent().apply {
                putExtra("EXTRA_BOOLEAN_KEY", true)
                putExtra("EXTRA_PERSON_KEY", person1)
            }
            setResult(RESULT_OK,resultIntent)
            finish()
        }


    }
}