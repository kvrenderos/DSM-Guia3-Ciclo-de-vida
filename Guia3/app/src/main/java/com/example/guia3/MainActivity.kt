package com.example.guia3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //1. Referencia al archivo layout
        setContentView(R.layout.activity_main)
        // 2. Registro del observador
        lifecycle.addObserver(MyLifeCycleObserver())
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
        mostrarToast("onDestroy")
    }
    private fun mostrarToast(
        mensaje: String,
        duracion: Int = Toast.LENGTH_SHORT
    ){
        Toast.makeText(
            this,
            "MainActivity -> $mensaje",
            duracion
        ).show()
    }
}