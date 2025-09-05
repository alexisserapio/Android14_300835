package com.example.android14.practicas.compose

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R

class ComposeFormsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_compose_forms)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val composeView = findViewById<ComposeView>(R.id.formView)
        composeView.setContent {
            FormComposable()
        }
    }
}

@Composable
fun FormComposable(){
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var isChecked by rememberSaveable { mutableStateOf(false) }
    var selectedOption by rememberSaveable { mutableStateOf("") }

    val isFormValid = name.isNotBlank()&&email.isNotBlank()&& isChecked && selectedOption.isNotBlank()

    Box(modifier = Modifier.fillMaxSize()
        .padding(16.dp),
        contentAlignment = Alignment.Center){

        Card(modifier = Modifier
            .fillMaxSize(),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(16.dp)
        ){
            LazyColumn( modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)){

                item {
                    Box(modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center){
                        Image(
                            contentDescription = "Logo de la app",
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            modifier = Modifier.size(100.dp)
                        )
                    }
                }

                item{
                    Text("Formulario de Registro", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                }

                item{
                    TextField(value = name,
                        onValueChange = { name = it},
                        label = {Text("Nombre Completo")},
                        modifier = Modifier.fillMaxWidth())
                }

                item{
                    TextField(value = email,
                        onValueChange = { email = it},
                        label = {Text("Correo Electronico")},
                        modifier = Modifier.fillMaxWidth())
                }

                item{
                    Row(verticalAlignment = Alignment.CenterVertically){
                        RadioButton(selected = selectedOption == "Masculino",
                            onClick = {selectedOption = "Masculino"})
                        Text("Hombre")

                        RadioButton(selected = selectedOption == "Femenino",
                            onClick = {selectedOption = "Femenino"})
                        Text("Mujer")
                    }
                }
                item{
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Checkbox(checked = isChecked, onCheckedChange = {isChecked = it})
                        Text("Acepto Términos y Condiciones")
                    }
                }
                /*item{
                    Spacer(modifier = Modifier.height(600.dp))
                }*/
                item {
                    Button(onClick = {}, modifier = Modifier.fillMaxWidth(), enabled = isFormValid) {
                        Text("Enviar")
                    }
                }

            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun FormPreview(){
    FormComposable()
}