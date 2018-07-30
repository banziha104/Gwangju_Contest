package com.nicname.iyeongjun.gwangju_contest.ui.fragments.weather

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nicname.iyeongjun.gwangju_contest.api.model.weather.WeatherModel
import io.reactivex.subjects.BehaviorSubject

class WeatherViewModelFactory(val driver : BehaviorSubject<WeatherModel>) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherViewModel(driver) as T
    }
}