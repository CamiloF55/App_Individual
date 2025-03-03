package com.example.formulario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form2)


            val Form_Form = findViewById<Button>(R.id.form_check)
        Form_Form.setOnClickListener{
            FormToCheck()
        }

    }
    private fun FormToCheck() {
        val o = Intent (this, CheckActivity2::class.java)
        startActivity(o)
    }
}