package com.nicname.iyeongjun.gwangju_contest.ui.activities.splash

import android.arch.lifecycle.ViewModel
import com.nicname.iyeongjun.gwangju_contest.api.inter.WeatherApi
import com.nicname.iyeongjun.gwangju_contest.api.model.rent.RentModel
import com.nicname.iyeongjun.gwangju_contest.api.model.storage.StorageModel
import com.nicname.iyeongjun.gwangju_contest.api.model.weather.WeatherModel
import io.reactivex.subjects.BehaviorSubject

class SplashViewModel(val weatherApi: WeatherApi,
                      val weatherDriver: BehaviorSubject<WeatherModel>,
                      val rentModel: RentModel,
                      val storageModel : StorageModel) : ViewModel()