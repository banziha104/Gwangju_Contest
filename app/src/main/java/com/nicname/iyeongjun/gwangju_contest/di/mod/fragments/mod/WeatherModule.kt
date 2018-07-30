package com.nicname.iyeongjun.gwangju_contest.di.mod.fragments.mod

import com.nicname.iyeongjun.gwangju_contest.api.inter.WeatherApi
import com.nicname.iyeongjun.gwangju_contest.api.model.weather.WeatherModel
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.tour.TourViewModelFactory
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.weather.WeatherViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.BehaviorSubject


@Module
class WeatherModule{
    @Provides
    fun provideTourViewModelFactory(driver : BehaviorSubject<WeatherModel>) = WeatherViewModelFactory(driver)
}

