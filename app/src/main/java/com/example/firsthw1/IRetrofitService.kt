package com.example.firsthw1

import android.telecom.Call
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IRetrofitService {

    //GET 예제
    @GET("/v1/{bpi}/currentprice.json")
    fun getBitResponse(
        @Path("bpi") bpi:String
    ) : retrofit2.Call<BitResponse>

    /*
    //GET 예제
    @GET("/v1/{bpi}/currentprice.json")
    fun getBitResponse(
        @Query("time") time: String?,
        @Query("chartName") chartName: String?,
    ) : retrofit2.Call<BitResponse>
*/
}
