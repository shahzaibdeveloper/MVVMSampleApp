package com.android.mvvmsampleapp.data.network

import android.provider.ContactsContract
import com.android.mvvmsampleapp.data.network.responses.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {

    //https://bizztrade.co.uk/globalize/globalize_login.php

    @FormUrlEncoded
    @POST("globalize_login.php")
   suspend fun userLogin(                                             // suspend remove

        @Field("user_email") email: String,
        @Field("user_pass") password:String
    ): Response<AuthResponse>                                                       //Call<ResponseBody> removd authresponse


   companion object{
      operator fun invoke(): MyApi{
          return Retrofit.Builder()
              .baseUrl("https://bizztrade.co.uk/globalize/")
               .addConverterFactory(GsonConverterFactory.create())
              .build()
              .create(MyApi::class.java)
       }
  }





}