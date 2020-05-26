package com.example.invetario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inicio_administrador.*

class InicioEmpleado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicioempleado)
        btnRegistro.setOnClickListener {
            val intent: Intent = Intent(this, RegistroAdmin::class.java)
            startActivity(intent)
        }
        btnVolver.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnOlvido.setOnClickListener {
            val intent:Intent = Intent(this, OlvidoContraAdmin::class.java)
            startActivity(intent)
        }
        btnIngresar.setOnClickListener{
            val intent:Intent = Intent(this, MenuEmpleado::class.java)
            startActivity(intent)
        }

    }
}
