package com.example.invetario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cambio_contra.*
import kotlinx.android.synthetic.main.activity_pedido_emp.*

class CambioContra : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cambio_contra)

        btnCambiarCon.setOnClickListener{
            val intent: Intent = Intent(this, NuevaContra::class.java)
            startActivity(intent)
        }
        btnCSEm.setOnClickListener{
            val intent: Intent = Intent(this, InicioEmpleado::class.java)
            startActivity(intent)
        }
    }
}
