package com.surya.prayertimekotlin.presenter

import android.content.Context
import com.surya.prayertimekotlin.model.Item
import com.surya.prayertimekotlin.model.Shalat
import com.surya.prayertimekotlin.service.RetrofitService
import com.surya.prayertimekotlin.view.ShalatView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShalatPresenter(context: Context){
    val shalatView = context as ShalatView

    fun getDataFromApi(city: String){
        RetrofitService.create()
            .getApi(city)
            .enqueue(object : Callback<Shalat>{
                override fun onFailure(call: Call<Shalat>, t: Throwable) {
                    shalatView.onGetDataErrorFromApi(t)
                }

                override fun onResponse(call: Call<Shalat>, response: Response<Shalat>) {
                    shalatView.onGetDataCompleteFromApi(response.body()?.items?.get(0) as Item)
                }

            })

    }
}