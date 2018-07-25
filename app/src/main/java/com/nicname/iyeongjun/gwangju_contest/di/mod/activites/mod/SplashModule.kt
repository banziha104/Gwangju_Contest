package com.nicname.iyeongjun.gwangju_contest.di.mod.activites.mod

import com.nicname.iyeongjun.gwangju_contest.api.inter.WeatherApi
import com.nicname.iyeongjun.gwangju_contest.api.model.rent.RentModel
import com.nicname.iyeongjun.gwangju_contest.api.model.weather.WeatherModel
import com.nicname.iyeongjun.gwangju_contest.ui.activities.splash.SplashViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.BehaviorSubject


@Module
class SplashModule{

    @Provides
    fun provideSplashViewModelFactory(weatherApi : WeatherApi,
                                      weatherDriver : BehaviorSubject<WeatherModel>,
                                      rentModel: RentModel)
            = SplashViewModelFactory(weatherApi,weatherDriver,rentModel)
}