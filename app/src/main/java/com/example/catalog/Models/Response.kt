package com.example.catalog.Models

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("furnitures")
	val furnitures: List<FurnituresItem?>? = null
)

data class FurnituresItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("price")
	val price: String? = null,

	@field:SerializedName("rating")
	val rating: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("product_name")
	val productName: String? = null
)
