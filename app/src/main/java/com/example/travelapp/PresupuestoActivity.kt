package com.example.travelapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PresupuestoActivity : AppCompatActivity() {

    private lateinit var activityName: EditText
    private lateinit var activityValue: EditText
    private lateinit var activityDays: EditText
    private lateinit var addActivityButton: Button
    private lateinit var totalBudget: TextView

    private var total = 0.0 // Almacena el total acumulado de todas las actividades

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presupuesto)

        // Inicializar las vistas del layout
        activityName = findViewById(R.id.activity_name)
        activityValue = findViewById(R.id.activity_value)
        activityDays = findViewById(R.id.activity_days)
        addActivityButton = findViewById(R.id.add_activity_button)
        totalBudget = findViewById(R.id.total_budget)


        addActivityButton.setOnClickListener {
            val name = activityName.text.toString()
            val valueString = activityValue.text.toString()
            val daysString = activityDays.text.toString()


            if (name.isNotEmpty() && valueString.isNotEmpty() && daysString.isNotEmpty()) {
                val value = valueString.toDoubleOrNull()
                val days = daysString.toIntOrNull()


                if (value != null && days != null) {
                    // Suma al total el valor de la actividad multiplicado por los días
                    total += value * days
                    // Actualiza el TextView con el nuevo total formateado a dos decimales
                    totalBudget.text = String.format("%.2f", total)
                } else {
                    // Mostrar un mensaje de error si los valores no son numéricos válidos
                    Toast.makeText(this, "Por favor, ingresa valores numéricos válidos", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Mostrar un mensaje de error si alguno de los campos está vacío
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
