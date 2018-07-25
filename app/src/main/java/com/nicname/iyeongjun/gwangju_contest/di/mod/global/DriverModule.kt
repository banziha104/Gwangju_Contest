package com.nicname.iyeongjun.gwangju_contest.di.mod.global

import com.nicname.iyeongjun.gwangju_contest.api.model.weather.WeatherModel
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Singleton

@Module
class DriverModule{
    @Provides
    @Singleton
    fun provideWeatherDriver() : BehaviorSubject<WeatherModel> = BehaviorSubject.create<WeatherModel>()
}