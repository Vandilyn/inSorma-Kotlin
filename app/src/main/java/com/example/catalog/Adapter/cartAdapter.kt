package com.example.catalog.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.catalog.Models.Cart
import com.example.catalog.Models.cartList
import com.example.catalog.R
import com.squareup.picasso.Picasso

class cartAdapter(): RecyclerView.Adapter<cartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart,parent,false)
        val viewHolder = ViewHolder(view)
        viewHolder.checkout.setOnClickListener{
            cartList.removeAt(viewHolder.adapterPosition)
            notifyDataSetChanged()
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.judul.text = cartList.get(position).nama
        Picasso.get().load(cartList.get(position).gambar).into(holder.gambar)
    }

    override fun getItemCount(): Int {
        if(cartList != null){
            return cartList.size
        }
        return 0
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var gambar : ImageView = itemView.findViewById(R.id.gambarBarang)
        var judul : TextView = itemView.findViewById(R.id.judulBarang)
        var checkout : Button = itemView.findViewById(R.id.checkoutBtn)
    }
}