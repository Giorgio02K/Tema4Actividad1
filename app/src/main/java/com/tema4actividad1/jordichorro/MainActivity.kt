package com.tema4actividad1.jordichorro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var numeroCalcular: TextView
    private var primerNumero: Double = 0.0
    private var operador: Char = ' '

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        numeroCalcular = findViewById(R.id.numeroCalcular)

        // Listeners para los botones de números
        findViewById<Button>(R.id.btn0).setOnClickListener {
            agregarNumero("0")
        }
        findViewById<Button>(R.id.btn1).setOnClickListener {
            agregarNumero("1")
        }
        findViewById<Button>(R.id.btn2).setOnClickListener {
            agregarNumero("2")
        }
        findViewById<Button>(R.id.btn3).setOnClickListener {
            agregarNumero("3")
        }
        findViewById<Button>(R.id.btn4).setOnClickListener {
            agregarNumero("4")
        }
        findViewById<Button>(R.id.btn5).setOnClickListener {
            agregarNumero("5")
        }
        findViewById<Button>(R.id.btn6).setOnClickListener {
            agregarNumero("6")
        }
        findViewById<Button>(R.id.btn7).setOnClickListener {
            agregarNumero("7")
        }
        findViewById<Button>(R.id.btn8).setOnClickListener {
            agregarNumero("8")
        }
        findViewById<Button>(R.id.btn9).setOnClickListener {
            agregarNumero("9")
        }

        // Listener para el botón de punto
        findViewById<Button>(R.id.btnPunto).setOnClickListener {
            if (!editText.text.contains(".")) {
                agregarNumero(".")
            }
        }

        // Listeners para los botones de operaciones
        findViewById<Button>(R.id.btnSuma).setOnClickListener {
            operador = '+'
        }
        findViewById<Button>(R.id.btnResta).setOnClickListener {
            operador = '-'
        }
        findViewById<Button>(R.id.btnMulti).setOnClickListener {
            operador = '*'
        }
        findViewById<Button>(R.id.btnDivision).setOnClickListener {
            operador = '/'
        }

        // Listener para el botón de igual
        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            calcular()
        }



        // Listener para el botón de borrar
        findViewById<EditText>(R.id.btnClear).setOnClickListener {
            primerNumero = 0.0
            operador = ' '
        }
    }

    private fun agregarNumero(numero: String) {
        editText.setText(editText.text.toString() + numero)
    }

    private fun calcular() {
        if (operador != ' ') {

            val segundoNumero: Double? = editText.text.toString().toDoubleOrNull()

            if (segundoNumero != null) {
                when (operador) {
                    '+' -> primerNumero += segundoNumero
                    '-' -> primerNumero -= segundoNumero
                    '*' -> primerNumero *= segundoNumero
                    '/' -> primerNumero /= segundoNumero
                }

                numeroCalcular.text = primerNumero.toString()
                operador = ' '
            }else{
                println("Error en la operacion")
            }

        }
    }
}








