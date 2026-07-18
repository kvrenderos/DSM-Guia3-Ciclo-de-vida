package com.example.guia3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2) // o el nombre de tu XML
        //1. Referencia al boton
        btnRegresar = findViewById(R.id.btnRegresar)
        //3. Registro del observador
        lifecycle.addObserver(MyLifeCycleObserver("MainActivity2"))

        //4. Listener del boton
        btnRegresar.setOnClickListener {
            //5. Uso de un intent explicito para iniciar una nueva Activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        mostrarToast("onCreate")
    }
    override fun onStart() {
        super.onStart()
        mostrarToast("onStart")
    }

    override fun onResume() {
        super.onResume()
        mostrarToast("onResume")
    }

    override fun onPause() {
        super.onPause()
        mostrarToast("onPause")
    }

    override fun onStop() {
        super.onStop()
        mostrarToast("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        mostrarToast("onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
    }

    private fun mostrarToast(
        mensaje: String,
        duracion :Int = Toast.LENGTH_SHORT
    ){
        Toast.makeText(
            this,
            "MainActivity2-> $mensaje",
            duracion
        ).show()
    }

}
