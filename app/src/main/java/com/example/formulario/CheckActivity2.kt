package com.example.formulario

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class CheckActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check2)

        mostrarDatos() // Recupera y muestra los datos almacenados en SharedPreferences

        // Configura el botón para regresar a la pantalla principal
        val checkForm = findViewById<Button>(R.id.check_main)
        checkForm.setOnClickListener {
            formToMain() // Llama a la función para volver a MainActivity
        }
    }


     // Recupera los datos almacenados en SharedPreferences y los muestra en el TextView con id "idMostrar".

    private fun mostrarDatos() {
        // Obtiene la instancia de SharedPreferences con el nombre "MyPrefs"
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        // Recupera los valores almacenados; si no existen, usa un valor por defecto "No ingresado"
        val tipo = sharedPreferences.getString("tipo", "No ingresado") ?: "No ingresado"
        val categoria = sharedPreferences.getString("categoria", "No ingresado") ?: "No ingresado"
        val urgencia = sharedPreferences.getString("urgencia", "No ingresado") ?: "No ingresado"
        val fecha = sharedPreferences.getString("fecha", "No ingresado") ?: "No ingresado"
        val descripcion = sharedPreferences.getString("descripcion", "No ingresado") ?: "No ingresado"

        // Formatea los datos correctamente
        val datos = """
            Los datos que ingresaste son los siguientes:
            
            Tipo: $tipo
            Categoría: $categoria
            Urgencia: $urgencia
            Fecha: $fecha
            Descripción: $descripcion
            
            Haremos lo posible para solucionar el error lo más rápido posible.
        """.trimIndent()

        // Asigna el texto formateado al TextView con id "idMostrar"
        findViewById<TextView>(R.id.idMostrar).text = datos
    }

    // Navega de regreso a MainActivity
    private fun formToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Cierra la actividad actual para evitar que el usuario regrese con el botón de retroceso
    }
}
