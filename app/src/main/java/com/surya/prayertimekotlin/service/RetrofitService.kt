package com.surya.prayertimekotlin.service

import com.surya.prayertimekotlin.model.Shalat
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("{city}.json?key=6be8270f3593eb0b8847b52a0007fca6")
    fun getApi(@Path ("city") city: String): Call<Shalat>

    companion object {
        fun create(): RetrofitService{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://muslimsalat.com")
                .build()

            return retrofit.create(RetrofitService::class.java)
        }
    }

}