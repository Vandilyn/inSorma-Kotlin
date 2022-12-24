package com.example.catalog.Fragments.MenuActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catalog.API.ApiInterface
import com.example.catalog.Adapter.recyclerAdapter
import com.example.catalog.DetailActivity
import com.example.catalog.Models.FurnituresItem
import com.example.catalog.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    lateinit var mrecyclerView: RecyclerView
    private lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val name : TextView = view.findViewById(R.id.name)
        auth = Firebase.auth
        name.setText(auth.currentUser?.displayName.toString())
        mrecyclerView = view.findViewById(R.id.recyclerView)
        getData()
        return view
    }
    private fun getData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://mocki.io/v1/")
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<com.example.catalog.Models.Response?> {
            override fun onResponse(
                call: Call<com.example.catalog.Models.Response?>,
                response: Response<com.example.catalog.Models.Response?>
            ) {
                if(response.isSuccessful){
                    val responseBody = response.body()
                    val dataFurniture = responseBody?.furnitures
                    val madapter = recyclerAdapter(dataFurniture)
                    mrecyclerView.apply {
                        layoutManager = LinearLayoutManager(context)
                        setHasFixedSize(true)
                        madapter.notifyDataSetChanged()
                        adapter = madapter
                    }
                }
            }

            override fun onFailure(call: Call<com.example.catalog.Models.Response?>, t: Throwable) {
                Toast.makeText(context, "Gagal cuy", Toast.LENGTH_SHORT).show()
            }
        })
    }

}