package com.example.catalog.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.catalog.DetailActivity
import com.example.catalog.Models.FurnituresItem
import com.example.catalog.Models.Response
import com.example.catalog.R
import com.squareup.picasso.Picasso

class recyclerAdapter(val furnitureList : List<FurnituresItem?>?):
    RecyclerView.Adapter<recyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        val viewHolder : ViewHolder = ViewHolder(view)
        viewHolder.ingfo.setOnClickListener{
            val intent : Intent = Intent(parent.context, DetailActivity::class.java).also{
                val pos = viewHolder.adapterPosition
                it.putExtra("gambar", furnitureList?.get(pos)?.image.toString())
                it.putExtra("nama",furnitureList?.get(pos)?.productName.toString())
                it.putExtra("desc",furnitureList?.get(pos)?.description.toString())
            }
            parent.context.startActivity(intent)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(furnitureList?.get(position)?.image).into(holder.gambar)
        holder.nama.text = furnitureList?.get(position)?.productName
        holder.desc.text = furnitureList?.get(position)?.description
    }

    override fun getItemCount(): Int {
        if(furnitureList != null){
            return furnitureList.size
        }
        return 0
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val gambar : ImageView =  itemView.findViewById(R.id.gambarBarang)
        val nama : TextView = itemView.findViewById(R.id.namaBarang)
        val desc : TextView = itemView.findViewById(R.id.desc)
        val ingfo : LinearLayout = itemView.findViewById(R.id.infoBarang)
    }
}
