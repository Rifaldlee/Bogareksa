package com.bogareksa.io.retrofit

import com.bogareksa.io.response.ResponseAuth
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Query

interface ApiService {
    @FormUrlEncoded
    @POST("login")
    fun postLogin(@Field("email") email: String, @Field("password") password: String):
            Call<ResponseAuth>


    @FormUrlEncoded
    @POST("register")
    fun postRegister(@Field("email") email: String, @Field("password") password: String, @Field("username") username : String, @Field("role") role : String):
            Call<ResponseAuth>
}