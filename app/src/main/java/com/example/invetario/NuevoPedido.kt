package com.example.invetario

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_nuevo_pedido.*
import kotlinx.android.synthetic.main.activity_pedido_emp.*
import java.util.*

class NuevoPedido : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_pedido)

        btnContinuarP.setOnClickListener{
            val intent: Intent = Intent(this, PedidoEmp::class.java)
            startActivity(intent)
        }

        //Calendario
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        // BOTON CLICK PARA MOSTRAR CUADRO DE FECHA
        btn3.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, mYear, mMont, mDay->
                dateTv.setText(""+ mDay + "/" + mMont +"/"+ mYear)}, year, month, day)
            dpd.show()
        }
    }
}
