package com.example.invetario

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.biometric.BiometricPrompt
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_olvido_admin.*
import kotlinx.android.synthetic.main.activity_registroadmin.*
import java.util.concurrent.Executor

class RegistroAdmin : AppCompatActivity() {
    private val executor = Executor { }
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
              }
    }
    private fun guardarPersona(){
        val nombre = txtNombre.text.toString().trim()
        val apellido = txtApellido.text.toString().trim()
        val cedula = txtCedula.text.toString().trim()
        val correo = txtCorreo.text.toString().trim()
        val contraseña = txtContra.text.toString().trim()
        val ref = FirebaseDatabase.getInstance().getReference("Personas")
        val personaId = ref.push().key
        val id = personaId.toString()
        val persona = Persona(id,nombre,apellido,cedula,correo,contraseña)
        ref.child(id).setValue(persona).addOnCompleteListener{
            Toast.makeText(applicationContext, " Persona guardada", Toast.LENGTH_LONG).show()
            if  (txtCorreo.text.isNotEmpty() &&  txtContra.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(txtCorreo.text.toString(),
                        txtContra.text.toString()).addOnCompleteListener{
                        if (it.isSuccessful){
                            login()
                        }
                        else{
                            mostrar()
                        }
                    }
        }
    }
}
    private fun mostrar(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Hay Error")
        builder.setMessage("tengo un error de logion")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
     private fun login(){
         val intent:Intent = Intent(this, InicioAdministradorActivity::class.java)
         startActivity(intent)
     }
    }




