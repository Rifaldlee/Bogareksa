package com.bogareksa.ui.penjual.listProductPage.component

import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bogareksa.io.response.MyProductsItem
import com.bogareksa.io.response.ResponseProducts
import com.bogareksa.io.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductSellerViewModel : ViewModel(){
    private val _listProduct = MutableLiveData<List<MyProductsItem>>()
    val listProducts: LiveData<List<MyProductsItem>> = _listProduct

    fun findProducts(token : String) {
        Log.d("mulai cari product","cari product cuy")
        val client = ApiConfig.getApiService().getUserData(token)
        client.enqueue(object : Callback<ResponseProducts> {
            override fun onResponse(
                call: Call<ResponseProducts>,
                response: Response<ResponseProducts>
            ) {

                if (response.isSuccessful) {
                    _listProduct.value = response.body()?.myProducts
                    Log.d("berhasil respons product","success product cuy")

                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseProducts>, t: Throwable) {

                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}