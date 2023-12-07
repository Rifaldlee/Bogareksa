package com.bogareksa.ui.auth.component

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bogareksa.io.response.ResponseAuth
import com.bogareksa.io.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginViewModel : ViewModel() {
    private val _authData = MutableLiveData<ResponseAuth>()
    val authData : LiveData<ResponseAuth> = _authData

    fun getAuthLogin(email : String,pass : String){
        val client =ApiConfig.getApiService().postLogin(email,pass)
        client.enqueue(object :retrofit2.Callback<ResponseAuth> {
            override fun onResponse(
                call: Call<ResponseAuth>,
                response: Response<ResponseAuth>
            ) {
                if (response.isSuccessful) {
                    _authData.value = response.body()
                } else {
                    Log.e("AuthLoginViewModel", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseAuth>, t: Throwable) {
                Log.e("AuthLoginViewModel Error", "onFailure: ${t.message.toString()}")
            }

        })
    }





}