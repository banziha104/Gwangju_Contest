package com.nicname.iyeongjun.gwangju_contest.ui.activities.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nicname.iyeongjun.gwangju_contest.R
import com.nicname.iyeongjun.gwangju_contest.api.inter.WeatherApi
import com.nicname.iyeongjun.gwangju_contest.const.T_BASE_URL
import dagger.android.support.DaggerAppCompatActivity
import okhttp3.ResponseBody
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : DaggerAppCompatActivity(),AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test()
    }

    fun test(){
        val temp = Retrofit.Builder()
                .baseUrl(T_BASE_URL)
                .build()

        temp
                .create(WeatherApi::class.java)
                .getWeather("37.453973","127.127015")
//                .enqueue(object : Callback<ResponseBody>{
//                    override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
//                        t?.printStackTrace()
//                    }
//
//                    override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
//                        info { response?.body()?.string() }
//                    }
//                })
    }
}

