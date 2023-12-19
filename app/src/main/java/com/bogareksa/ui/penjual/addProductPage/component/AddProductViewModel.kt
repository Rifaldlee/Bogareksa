package com.bogareksa.ui.penjual.addProductPage.component

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bogareksa.io.response.ResponseAddProduct
import com.bogareksa.io.response.ResponseDeleteProduct
import com.bogareksa.io.retrofit.ApiConfig
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class AddProductViewModel : ViewModel(){

    private var _upResponse =  MutableLiveData<ResponseAddProduct>()
    var upResponse : LiveData<ResponseAddProduct> = _upResponse


    private var _isLogin = MutableLiveData<Boolean>(false)
    var isLogin : LiveData<Boolean> = _isLogin

    var hasImage : Boolean = false


    fun uploadProduct(token:String,name:String,price:Int,uploaded:File){
        _isLogin.value = true

        val builder = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("price", price.toString())
            .addFormDataPart("name", name)
            .addPart(MultipartBody.Part.createFormData("uploadedFile", uploaded.name, RequestBody.create(
                "multipart/form-data".toMediaTypeOrNull(), uploaded)))

        val requestBody = builder.build()
//
//        val filePart = MultipartBody.Part.createFormData(
//            "uploadedFile",
//            uploaded.name,
//            RequestBody.create("image/png".toMediaTypeOrNull(), uploaded)
//        )

//        val client = ApiConfig.getApiService().addProduct(token,filePart,price,name)
        val client = ApiConfig.getApiService().addProduct(token,requestBody)
        client.enqueue(object : Callback<ResponseAddProduct> {

            override fun onResponse(
                call: Call<ResponseAddProduct>,
                response: Response<ResponseAddProduct>
            ) {
                if (response.isSuccessful) {
                    _upResponse.value = response.body()
                    Log.d("berhasil add product product","success add new product cuy ${_upResponse.value?.data?.name}")
                    _isLogin.value =  false
                } else {
                    Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                    _isLogin.value =  false
                }
            }

            override fun onFailure(call: Call<ResponseAddProduct>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
                _isLogin.value =  false
            }
        })
    }

}