package com.example.catalog.API

import com.example.catalog.Models.FurnituresItem
import com.example.catalog.Models.Response
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("5f379081-2473-4494-9cc3-9e808772dc54")
    fun getData(): Call<Response>
}