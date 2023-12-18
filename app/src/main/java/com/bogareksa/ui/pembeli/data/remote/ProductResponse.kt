package com.bogareksa.ui.pembeli.data.remote

import com.google.gson.annotations.SerializedName

data class ProductResponse(

	@field:SerializedName("productList")
	val productList: List<ProductsItem>?
)

data class PredictedData(

	@field:SerializedName("status")
	val status: Status? = null,

	@field:SerializedName("detectedDate")
	val detectedDate: String? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class PredictionData(

	@field:SerializedName("statusMsg")
	val statusMsg: String? = null,

	@field:SerializedName("responseCode")
	val responseCode: Int? = null
)

data class Status(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("detected_date")
	val detectedDate: String? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class ProductsItem(

	@field:SerializedName("productId")
	val productId: String? = null,

	@field:SerializedName("imagePath")
	val imagePath: String? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("imageUrl")
	val imageUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("predictionData")
	val predictionData: PredictionData? = null,

	@field:SerializedName("ownedBy")
	val ownedBy: String? = null,

	@field:SerializedName("desc")
	val desc: String? = null,

	@field:SerializedName("predictedData")
	val predictedData: PredictedData? = null
)
