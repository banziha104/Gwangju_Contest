package com.nicname.iyeongjun.gwangju_contest.ui.activities.splash

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nicname.iyeongjun.gwangju_contest.api.inter.WeatherApi
import com.nicname.iyeongjun.gwangju_contest.api.model.rent.RentModel
import com.nicname.iyeongjun.gwangju_contest.api.model.storage.StorageModel
import com.nicname.iyeongjun.gwangju_contest.api.model.weather.WeatherModel
import io.reactivex.subjects.BehaviorSubject

class SplashViewModelFactory(val weatherApi: WeatherApi,
                             val weatherDriver: BehaviorSubject<WeatherModel>,
                             val rentModel: RentModel,
                             val storageModel : StorageModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SplashViewModel(weatherApi, weatherDriver, rentModel,storageModel) as T
    }
}