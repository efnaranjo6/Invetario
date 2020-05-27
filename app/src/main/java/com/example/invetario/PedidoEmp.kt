package com.example.invetario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_empleado.*
import kotlinx.android.synthetic.main.activity_pedido_emp.*

class PedidoEmp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido_emp)

        //btnIP.setOnClickListener{
          //  val intent: Intent = Intent(this, InventarioEmp::class.java)
            //startActivity(intent)
        // }
        btnNueP.setOnClickListener{
            val intent: Intent = Intent(this, NuevoPedido::class.java)
            startActivity(intent)
        }
        btnIP.setOnClickListener{
            val intent: Intent = Intent(this, InventarioEm::class.java)
            startActivity(intent)
        }

    }
}
