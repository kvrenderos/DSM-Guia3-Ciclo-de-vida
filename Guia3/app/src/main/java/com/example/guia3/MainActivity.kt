package com.example.guia3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etNombres: EditText
    private lateinit var etApellidos: EditText
    private lateinit var etCorreo: EditText
    private lateinit var etTelefono: EditText
    private lateinit var etEdad: EditText
    private lateinit var btnValidar: Button
    private lateinit var btnIrSecond: Button
    private lateinit var btnIrThird: Button
    private lateinit var tvResumen: TextView

    private var resumen = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(MyLifeCycleObserver("MainActivity"))

        etNombres = findViewById(R.id.etNombres)
        etApellidos = findViewById(R.id.etApellidos)
        etCorreo = findViewById(R.id.etCorreo)
        etTelefono = findViewById(R.id.etTelefono)
        etEdad = findViewById(R.id.etEdad)
        btnValidar = findViewById(R.id.btnValidar)
        btnIrSecond = findViewById(R.id.btnIrSecond)
        btnIrThird = findViewById(R.id.btnIrThird)
        tvResumen = findViewById(R.id.tvResumen)

        savedInstanceState?.let {
            etNombres.setText(it.getString(KEY_NOMBRES, ""))
            etApellidos.setText(it.getString(KEY_APELLIDOS, ""))
            etCorreo.setText(it.getString(KEY_CORREO, ""))
            etTelefono.setText(it.getString(KEY_TELEFONO, ""))
            etEdad.setText(it.getString(KEY_EDAD, ""))
            resumen = it.getString(KEY_RESUMEN, "")
            tvResumen.text = resumen
        }

        btnValidar.setOnClickListener {
            validarInformacion()
        }

        btnIrSecond.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        btnIrThird.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        mostrarToast("onCreate")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_NOMBRES, etNombres.text.toString())
        outState.putString(KEY_APELLIDOS, etApellidos.text.toString())
        outState.putString(KEY_CORREO, etCorreo.text.toString())
        outState.putString(KEY_TELEFONO, etTelefono.text.toString())
        outState.putString(KEY_EDAD, etEdad.text.toString())
        outState.putString(KEY_RESUMEN, resumen)
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

    private fun validarInformacion() {
        val nombres = etNombres.text.toString().trim()
        val apellidos = etApellidos.text.toString().trim()
        val correo = etCorreo.text.toString().trim()
        val telefono = etTelefono.text.toString().trim()
        val edadTexto = etEdad.text.toString().trim()

        if (nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() ||
            telefono.isEmpty() || edadTexto.isEmpty()
        ) {
            resumen = "Debe completar todos los campos."
            tvResumen.text = resumen
            Toast.makeText(this, resumen, Toast.LENGTH_SHORT).show()
            return
        }

        val edad = edadTexto.toIntOrNull()
        if (edad == null) {
            resumen = "La edad debe ser un valor numerico."
            tvResumen.text = resumen
            Toast.makeText(this, resumen, Toast.LENGTH_SHORT).show()
            return
        }

        val resultadoEdad = if (edad >= 18) "Es mayor de edad." else "No es mayor de edad."
        resumen = """
            Resumen de informacion:
            Nombres: $nombres
            Apellidos: $apellidos
            Correo electronico: $correo
            Telefono celular: $telefono
            Edad: $edad
            Resultado: $resultadoEdad
        """.trimIndent()
        tvResumen.text = resumen
    }

    private fun mostrarToast(
        mensaje: String,
        duracion: Int = Toast.LENGTH_SHORT
    ) {
        Toast.makeText(
            this,
            "MainActivity -> $mensaje",
            duracion
        ).show()
    }

    companion object {
        private const val KEY_NOMBRES = "nombres"
        private const val KEY_APELLIDOS = "apellidos"
        private const val KEY_CORREO = "correo"
        private const val KEY_TELEFONO = "telefono"
        private const val KEY_EDAD = "edad"
        private const val KEY_RESUMEN = "resumen"
    }
}
