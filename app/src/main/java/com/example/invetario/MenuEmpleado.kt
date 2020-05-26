package com.example.invetario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inicio_administrador.*
import kotlinx.android.synthetic.main.activity_menu_empleado.*

class MenuEmpleado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_empleado)

        btnCeSe.setOnClickListener{
            val intent:Intent = Intent(this, InicioEmpleado::class.java)
            startActivity(intent)
        }
        btnPerE.setOnClickListener{
            val intent:Intent = Intent(this, CambioContra::class.java)
            startActivity(intent)
        }
        btnPedE.setOnClickListener {
            val intent:Intent = Intent(this, PedidoEmp::class.java)
            startActivity(intent)
        }
        btnInvenE.setOnClickListener {
            val intent:Intent = Intent(this, InventarioEm::class.java)
            startActivity(intent)
        }


    }
}
