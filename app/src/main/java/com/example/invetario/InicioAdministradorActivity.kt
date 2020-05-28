package com.example.invetario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.Toast
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_inicio_administrador.*
import java.util.concurrent.Executor

class InicioAdministradorActivity : AppCompatActivity() {

    private lateinit var biometricManager: BiometricManager
    private  lateinit var biometricPrompt: BiometricPrompt

    private  lateinit var promptInfo: BiometricPrompt.PromptInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_administrador)
        biometricManager = BiometricManager.from(this)
        val executor = ContextCompat.getMainExecutor(this)

        checkhuella(biometricManager)
        btnVolver.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        biometricLoginButton.setOnClickListener {
            biometricPrompt = BiometricPrompt(this, executor,
             object  : BiometricPrompt.AuthenticationCallback(){
                 override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                     super.onAuthenticationError(errorCode, errString)
                     mbox("error compa")
                 }

                 override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                     super.onAuthenticationSucceeded(result)
                     inicio()
                 }

                 override fun onAuthenticationFailed() {
                     super.onAuthenticationFailed()
                     mbox("pailas compa")
                 }
             })

            promptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("sensor  biometrico ")
                .setDescription("presiona el sensor")
                .setNegativeButtonText("usar entrada nativa")
                .build()
            btnIngresar.setOnClickListener(){
                biometricPrompt.authenticate(promptInfo)
            }

        }



        btnIngresar.setOnClickListener {

            if  (txtCuenta.text.isNotEmpty() &&  txtContra.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(txtCuenta.text.toString(),
                        txtContra.text.toString()).addOnCompleteListener{
                        if (it.isSuccessful){
                             val interfaceAdmin:Intent = Intent(this, InterfazAdmin::class.java)
                            startActivity(interfaceAdmin)
                        }

                    }
            }

        }

        btnRegistro.setOnClickListener {
            val intent:Intent = Intent(this, RegistroAdmin::class.java)
            startActivity(intent)

    }
        }
    private fun mbox(message: String){
        Toast.makeText(applicationContext,message ,Toast.LENGTH_LONG).show()
    }
    private fun inicio(){
        val interfaceAdmin:Intent = Intent(this, InterfazAdmin::class.java)
        startActivity(interfaceAdmin)
    }
    private fun  checkhuella(biometricManager: BiometricManager){
        when(biometricManager.canAuthenticate()){
            BiometricManager.BIOMETRIC_SUCCESS->
                Toast.makeText(applicationContext, " La app usa huella",Toast.LENGTH_LONG).show()
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE ->
                Toast.makeText(applicationContext, " no detecta sensor de huella",Toast.LENGTH_LONG).show()
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE->
                Toast.makeText(applicationContext, "Actualmente desactivado ",Toast.LENGTH_LONG).show()
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED->
                Toast.makeText(applicationContext, "no hay sensor asosciado",Toast.LENGTH_LONG).show()
        }
}

}


