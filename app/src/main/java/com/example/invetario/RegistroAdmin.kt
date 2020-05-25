package com.example.invetario

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
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
    private fun guardarPersona(){
        val nombre = txtNombre.text.toString().trim()
        val apellido = txtApellido.text.toString().trim()
        val cedula = txtCedula.text.toString().trim()
        val correo = txtCorreo.text.toString().trim()
        val contraseña = txtNombre.text.toString().trim()

        val ref = FirebaseDatabase.getInstance().getReference("Personas")
        val personaId = ref.push().key
        val id = personaId.toString()
        val persona = Persona(id,nombre,apellido,cedula,correo,contraseña)
        ref.child(id).setValue(persona).addOnCompleteListener{
            Toast.makeText(applicationContext, " Persona guardada", Toast.LENGTH_LONG).show()

        }
    }
}
