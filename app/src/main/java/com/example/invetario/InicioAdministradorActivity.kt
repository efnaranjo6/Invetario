package com.example.invetario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_inicio_administrador.*

class InicioAdministradorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_administrador)
        btnVolver.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnOlvido.setOnClickListener {
            val intent:Intent = Intent(this, OlvidoContraAdmin::class.java)
            startActivity(intent)
        }
        btnIngresar.setOnClickListener {

            if  (txtCuenta.text.isNotEmpty() &&  txtContra.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(txtCuenta.text.toString(),
                        txtContra.text.toString()).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent:Intent = Intent(this, InterfazAdmin::class.java)
                            startActivity(intent)
                        }

                    }
            }

        }

        btnRegistro.setOnClickListener {
            val intent:Intent = Intent(this, RegistroAdmin::class.java)
            startActivity(intent)

    }
}
    private fun setup(){

    }
}
