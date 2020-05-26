package com.example.invetario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_empleado.*
import kotlinx.android.synthetic.main.activity_nueva_contra.*

class NuevaContra : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_contra)

        btnConfiE.setOnClickListener{
            val intent: Intent = Intent(this, MenuEmpleado::class.java)
            startActivity(intent)
        }

    }
}
