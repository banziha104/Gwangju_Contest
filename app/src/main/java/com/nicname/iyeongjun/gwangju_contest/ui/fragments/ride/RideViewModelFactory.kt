package com.nicname.iyeongjun.gwangju_contest.ui.fragments.ride

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nicname.iyeongjun.gwangju_contest.api.inter.WeatherApi

class RideViewModelFactory(val api : WeatherApi) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RideViewModel(api) as T
    }
}