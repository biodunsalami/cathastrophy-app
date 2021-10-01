package com.biodun.cathastrophy.api

import com.biodun.cathastrophy.Cat
import com.biodun.cathastrophy.api.models.Breed
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val BASEURL = "https://api.thecatapi.com/v1/"

interface ApiService {

    @GET("breeds")
    suspend fun getBreeds(@Query("api_key") api_key : String) : List<Breed>

    @GET("breeds")
    fun getBreeds2(@Query("api_key") api_key : String) : Call<List<Breed>>

}


val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory
    .create(moshi))
    .baseUrl(BASEURL)
    .build()

object Api{
    val apiService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}