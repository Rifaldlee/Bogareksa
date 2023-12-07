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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductSellerViewModel : ViewModel(){
    private val _listProduct = MutableLiveData<List<MyProductsItem>>()
    val listProducts: LiveData<List<MyProductsItem>> = _listProduct

    init {
        findRestaurant()
    }

    private fun findRestaurant() {
        val client = ApiConfig.getApiService().getUserData()
        client.enqueue(object : Callback<ResponseProducts> {
            override fun onResponse(
                call: Call<ResponseProducts>,
                response: Response<ResponseProducts>
            ) {

                if (response.isSuccessful) {
                    _listProduct.value = response.body()?.myProducts

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