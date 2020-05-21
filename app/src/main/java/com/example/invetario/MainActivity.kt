package com.example.invetario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       btnAdministrador.setOnClickListener {
            val intent:Intent = Intent(this, InicioAdministradorActivity::class.java)
            startActivity(intent)
       }
        btnEmpleado.setOnClickListener {
            val intent:Intent = Intent(this, InicioEmpleado::class.java)
            startActivity(intent)
        }


    }

}
