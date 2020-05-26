package com.example.invetario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inventario_em.*

class InventarioEm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventario_em)

        btnPI.setOnClickListener{
            val intent: Intent = Intent(this, PedidoEmp::class.java)
            startActivity(intent)
        }
    }
}
