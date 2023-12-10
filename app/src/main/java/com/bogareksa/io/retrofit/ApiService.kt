package com.bogareksa.io.retrofit

import com.bogareksa.io.response.ResponseAuth
import com.bogareksa.io.response.ResponseProducts
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
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

//    @Headers("Authorization : Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJmcmVzaCI6ZmFsc2UsImlhdCI6MTcwMjAxODI1NSwianRpIjoiNDVlM2QzNTUtNTMyYS00MWI2LWE0YjktYjUzOGM0NDc0NTc4IiwidHlwZSI6ImFjY2VzcyIsInN1YiI6InBoUTdCWXNiVnlkNjNaS3ZwdGJvQnNtM2JxYTIiLCJuYmYiOjE3MDIwMTgyNTUsImV4cCI6MTcwMjAxOTE1NX0.FLaCQUtb1uOy8l3UoxYUYOfZF4hNrzABsQwQuZxi-k4")
    @GET("products")
    fun getUserData(@Header("Authorization") token: String): Call<ResponseProducts>
}