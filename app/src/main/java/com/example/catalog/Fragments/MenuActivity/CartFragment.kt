package com.example.catalog.Fragments.MenuActivity

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catalog.Adapter.cartAdapter
import com.example.catalog.MenuActivity
import com.example.catalog.Models.Cart
import com.example.catalog.Models.cartList
import com.example.catalog.R
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class CartFragment : Fragment() {
    lateinit var recyclerView : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        recyclerView = view.findViewById(R.id.cartRecycler)
        loadRecycler()
        return view
    }

    fun loadRecycler(){
        val madapter = cartAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = madapter
            madapter.notifyDataSetChanged()
        }

    }

}