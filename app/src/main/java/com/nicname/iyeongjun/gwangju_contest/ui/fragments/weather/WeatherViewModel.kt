package com.nicname.iyeongjun.gwangju_contest.ui.fragments.weather

import android.arch.lifecycle.ViewModel
import com.nicname.iyeongjun.gwangju_contest.api.model.weather.WeatherModel
import io.reactivex.subjects.BehaviorSubject


class WeatherViewModel(val driver : BehaviorSubject<WeatherModel>) : ViewModel()