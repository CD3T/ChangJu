package com.example.firsthw1

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClass {

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.coindesk.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    val api = retrofit.create(IRetrofitService::class.java)

    fun getInstance(): IRetrofitService? {
        return api
    }

    /*
    private const val URL = "https://api.coindesk.com/v1/bpi/currentprice.json"

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: IRetrofitService = retrofit.create(IRetrofitService::class.java)
*/
/*
        val baseUrl = "https://api.coindesk.com/v1/bpi/currentprice.json/"

        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                // we need to add converter factory to
                // convert JSON object to Java object
                .build()

            val service: IRetrofitService = retrofit.create
        }*/


}