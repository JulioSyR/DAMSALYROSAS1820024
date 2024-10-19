package com.example.travelapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var presupuestoButton: Button
    private lateinit var segurosButton: Button
    private lateinit var hotelesButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        presupuestoButton = findViewById(R.id.presupuesto_button)
        segurosButton = findViewById(R.id.seguros_button)
        hotelesButton = findViewById(R.id.hoteles_button)

        presupuestoButton.setOnClickListener {
            val intent = Intent(this, PresupuestoActivity::class.java)
            startActivity(intent)
        }

        segurosButton.setOnClickListener {
            val intent = Intent(this, SegurosActivity::class.java)
            startActivity(intent)
        }

        hotelesButton.setOnClickListener {
            val intent = Intent(this, HotelesActivity::class.java)
            startActivity(intent)
        }
    }
}
