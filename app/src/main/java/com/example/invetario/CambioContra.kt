package com.example.invetario

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_cambio_contra.*
import kotlinx.android.synthetic.main.activity_menu_empleado.*
import kotlinx.android.synthetic.main.activity_pedido_emp.*
import java.util.*

class CambioContra : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cambio_contra)

        btnGuardarFoto.setOnClickListener{
            //  subirImagenAFB()
        }
        btnCambiarCon.setOnClickListener{
            val intent: Intent = Intent(this, NuevaContra::class.java)
            startActivity(intent)
        }
        btnCambiarFoto.setOnClickListener {
            Log.d("CambioContra", "Intenta mostrar selector de fotos")

            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 0)

        }
    }
    var selectedPhotoUri: Uri? = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null){
            //continua y mira que foto seleccionó
            Log.d("CambioContra", "La foto fue seleccionada")
            selectedPhotoUri  = data.data
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedPhotoUri)

            val bitmapDrawable = BitmapDrawable(bitmap)
            btnCambiarFoto.setBackgroundDrawable(bitmapDrawable)
            // btnPerEm.setBackgroundDrawable(bitmapDrawable)


        }
    }
    //private fun subirImagenAFB() {
      //  if (selectedPhotoUri == null) return

        //val filename = UUID.randomUUID().toString()
        //val ref = FirebaseStorage.getInstance().getReference("/imagenes/$filename")
        //ref.putFile(selectedPhotoUri!!)
          //  .addOnSuccessListener {
            //    Log.d("CambioContra", "Se ha subido la imagen: ${it.metadata?.path}")
            //}
    //}
}
