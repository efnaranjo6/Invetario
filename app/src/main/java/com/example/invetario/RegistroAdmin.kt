package com.example.invetario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_olvido_admin.*
import kotlinx.android.synthetic.main.activity_registroadmin.*

class RegistroAdmin : AppCompatActivity() {

    lateinit var txtNombre: EditText
    lateinit var txtApellido: EditText
    lateinit var txtCedula: EditText
    lateinit var txtContra: EditText
    lateinit var txtRepita: EditText
    lateinit var btnContinuar: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registroadmin)

        txtNombre = findViewById(R.id.txtNombre)
        txtApellido = findViewById(R.id.txtApellido)
        txtCedula = findViewById(R.id.txtCedula)
        txtContra = findViewById(R.id.txtContra)
        txtRepita = findViewById(R.id.txtRepita)
        btnContinuar = findViewById(R.id.btnContinuar)



        btnContinuar.setOnClickListener {
            guardarPersona()
            val intent: Intent = Intent(this, RegistroAdmin::class.java)
            startActivity(intent)
        }

    }
    private fun guardarPersona{
        val nombre = txtNombre.text.toString().trim()


    }
}
