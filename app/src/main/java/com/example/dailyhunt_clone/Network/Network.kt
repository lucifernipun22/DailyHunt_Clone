package com.tejeet.retrofitkotlin.Network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    companion object{   // its like Static in Java

        fun getInstance() : Retrofit{


            val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            val retrofitBuilder = Retrofit.Builder()
                .baseUrl("https://234b28b4757b.ngrok.io")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())

            return retrofitBuilder.build()

        }
    }
}