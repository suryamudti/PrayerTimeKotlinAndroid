package com.surya.prayertimekotlin.view

import com.surya.prayertimekotlin.model.Item

interface ShalatView{
    fun onGetDataCompleteFromApi(shalat: Item)
    fun onGetDataErrorFromApi(throwable: Throwable)
}