package com.example.dv_android.utils

import android.util.Log
import com.example.dv_android.models.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService{
    //@GET("6de6abfedb24f889e0b5f675edc50deb?fmt=raw&sole")
    @GET("users")
    suspend fun getUsers() : List<User>

    @POST("register")
    suspend fun saveUser(@Body user: User?):User
}


val retrofit:Retrofit = Retrofit.Builder()
    .baseUrl("http://10.0.2.2:5000/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()


val userService: UserService = retrofit.create(UserService::class.java)
