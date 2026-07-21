package com.example.guia3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    private lateinit var btnIrMain: Button
    private lateinit var btnIrSecond: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        lifecycle.addObserver(MyLifeCycleObserver("ThirdActivity"))

        btnIrMain = findViewById(R.id.btnIrMain)
        btnIrSecond = findViewById(R.id.btnIrSecond)

        btnIrMain.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnIrSecond.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
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
        mostrarToast("onDestroy")
    }

    private fun mostrarToast(
        mensaje: String,
        duracion: Int = Toast.LENGTH_SHORT
    ) {
        Toast.makeText(
            this,
            "ThirdActivity -> $mensaje",
            duracion
        ).show()
    }
}
