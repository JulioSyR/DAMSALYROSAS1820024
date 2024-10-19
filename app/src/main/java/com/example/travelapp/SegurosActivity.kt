package com.example.travelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater

class SegurosActivity : AppCompatActivity() {

    private lateinit var insuranceListLayout: LinearLayout

    private val insurances = listOf(
        Insurance("Seguro A", "Descripción del Seguro A", "$50 al mes", R.drawable.seguro_a),
        Insurance("Seguro B", "Descripción del Seguro B", "$70 al mes", R.drawable.seguro_b),
        Insurance("Seguro C", "Descripción del Seguro C", "$30 al mes", R.drawable.seguro_c)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seguros)

        insuranceListLayout = findViewById(R.id.insurance_list_layout)


        insurances.forEach { insurance ->
            val view = LayoutInflater.from(this).inflate(R.layout.item_insurance, insuranceListLayout, false)
            val imageView = view.findViewById<ImageView>(R.id.insurance_image)
            val nameTextView = view.findViewById<TextView>(R.id.insurance_name)
            val descriptionTextView = view.findViewById<TextView>(R.id.insurance_description)
            val priceTextView = view.findViewById<TextView>(R.id.insurance_price)

            imageView.setImageResource(insurance.imageResId)
            nameTextView.text = insurance.name
            descriptionTextView.text = insurance.description
            priceTextView.text = insurance.price

            insuranceListLayout.addView(view)
        }
    }

    data class Insurance(val name: String, val description: String, val price: String, val imageResId: Int)
}
