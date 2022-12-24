package com.example.catalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.catalog.Models.Cart
import com.example.catalog.Models.Response
import com.example.catalog.Models.cartList
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val image : ImageView = findViewById(R.id.itemImage)
        val title : TextView = findViewById(R.id.itemTitle)
        val overview : TextView = findViewById(R.id.itemOverview)
        val cart : Button = findViewById(R.id.addToCartBtn)

        val gambar = intent.getStringExtra("gambar")
        val nama = intent.getStringExtra("nama")
        val desc = intent.getStringExtra("desc")

        Picasso.get().load(gambar).into(image)
        title.text = nama
        overview.text = desc

        cart.setOnClickListener{
            Toast.makeText(this, nama + " berhasil ditambahkan ke cart!", Toast.LENGTH_SHORT).show()
            cartList.add(Cart(gambar.toString(),nama.toString(),desc.toString()))
            startActivity(Intent(this,MenuActivity::class.java))
        }
    }
}