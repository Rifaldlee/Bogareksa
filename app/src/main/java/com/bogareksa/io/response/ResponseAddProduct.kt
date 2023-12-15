package com.bogareksa.io.response

import com.google.gson.annotations.SerializedName

data class ResponseAddProduct(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: Status? = null
)

data class Data(

	@field:SerializedName("imagePath")
	val imagePath: String? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("imageUrl")
	val imageUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,


	@field:SerializedName("desc")
	val desc: String? = null
)

data class Status(

	@field:SerializedName("msg")
	val msg: String? = null,

	@field:SerializedName("code")
	val code: Int? = null
)
