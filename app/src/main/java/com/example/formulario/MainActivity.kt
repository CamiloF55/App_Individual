package com.example.formulario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Configura el botón para navegar a FormActivity2
        val MainForm = findViewById<Button>(R.id.main_form)
        MainForm.setOnClickListener {
            mainToForm() // Llama a la función para cambiar de actividad
        }

        // Configura el botón para salir de la aplicación
        val exitButton = findViewById<Button>(R.id.exit)
        exitButton.setOnClickListener {
            cerrarAplicacion() // Llama a la función para cerrar la app
        }
    }

    // Cambia de actividad y navega a FormActivity2
    private fun mainToForm() {
        val i = Intent(this, FormActivity2::class.java)
        startActivity(i)
    }

    //Cierra completamente la aplicación cuando el usuario presiona el botón "Salir". La función finishAffinity() finaliza todas las actividades abiertas.

    private fun cerrarAplicacion() {
        finishAffinity() // Cierra todas las actividades y finaliza la aplicación
    }
}
