package com.example.travelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater

class HotelesActivity : AppCompatActivity() {

    private lateinit var hotelListLayout: LinearLayout

    private val hotels = listOf(
        Hotel("Hotel A", "Descripción del Hotel A", "$100 por noche", R.drawable.hotel_a),
        Hotel("Hotel B", "Descripción del Hotel B", "$150 por noche", R.drawable.hotel_b),
        Hotel("Hotel C", "Descripción del Hotel C", "$120 por noche", R.drawable.hotel_c)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoteles)

        hotelListLayout = findViewById(R.id.hotel_list_layout)

        // Inflar cada hotel en la lista
        hotels.forEach { hotel ->
            val view = LayoutInflater.from(this).inflate(R.layout.item_hotel, hotelListLayout, false)
            val imageView = view.findViewById<ImageView>(R.id.hotel_image)
            val nameTextView = view.findViewById<TextView>(R.id.hotel_name)
            val descriptionTextView = view.findViewById<TextView>(R.id.hotel_description)
            val priceTextView = view.findViewById<TextView>(R.id.hotel_price)

            imageView.setImageResource(hotel.imageResId)
            nameTextView.text = hotel.name
            descriptionTextView.text = hotel.description
            priceTextView.text = hotel.price

            hotelListLayout.addView(view)
        }
    }

    data class Hotel(val name: String, val description: String, val price: String, val imageResId: Int)
}
