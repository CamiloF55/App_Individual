package com.example.formulario

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class FormActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Habilita la interfaz sin bordes para una mejor apariencia en dispositivos modernos
        setContentView(R.layout.activity_form2) // Establece el diseño de la actividad

        // Configura el botón para guardar los datos y cambiar a CheckActivity2
        val btnFormCheck = findViewById<Button>(R.id.form_check)
        btnFormCheck.setOnClickListener {
            guardarDatos() // Guarda los datos ingresados en SharedPreferences
            irACheckActivity() // Navega a la actividad CheckActivity2
        }
    }

    //Recupera los datos ingresados en los campos de texto y los guarda en SharedPreferences para que puedan ser utilizados en la siguiente actividad.

    private fun guardarDatos() {
        // Obtiene una instancia de SharedPreferences con el nombre "MyPrefs"
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Guarda los valores ingresados en cada campo de texto
        editor.putString("tipo", findViewById<EditText>(R.id.idTipo).text.toString())
        editor.putString("categoria", findViewById<EditText>(R.id.idCategoria).text.toString())
        editor.putString("urgencia", findViewById<EditText>(R.id.idUrgencia).text.toString())
        editor.putString("fecha", findViewById<EditText>(R.id.idFecha).text.toString())
        editor.putString("descripcion", findViewById<EditText>(R.id.idDescript).text.toString())

        editor.apply() // Aplica los cambios y guarda los datos de manera asíncrona
    }

    //Cambia de actividad y navega a CheckActivity2 donde se mostrarán los datos almacenados.

    private fun irACheckActivity() {
        val intent = Intent(this, CheckActivity2::class.java)
        startActivity(intent)
    }
}
