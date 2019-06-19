package com.surya.prayertimekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.surya.prayertimekotlin.model.Item
import com.surya.prayertimekotlin.presenter.ShalatPresenter
import com.surya.prayertimekotlin.view.ShalatView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ShalatView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ShalatPresenter(this).getDataFromApi("makassar")
    }

    override fun onGetDataCompleteFromApi(shalat: Item) {
        subuh.text = shalat.fajr
        dzuhur.text = shalat.dhuhr
        ashar.text = shalat.asr
        magrib.text = shalat.maghrib
        isya.text = shalat.isha
    }

    override fun onGetDataErrorFromApi(throwable: Throwable) {
        error("error  ------>>> ${throwable.localizedMessage}")
        Toast.makeText(this,"Error ${throwable.localizedMessage}",Toast.LENGTH_LONG).show()
    }
}
