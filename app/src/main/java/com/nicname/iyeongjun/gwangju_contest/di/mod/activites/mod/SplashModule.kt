package com.nicname.iyeongjun.gwangju_contest.di.mod.activites.mod

import com.nicname.iyeongjun.gwangju_contest.api.inter.TourApi
import com.nicname.iyeongjun.gwangju_contest.api.inter.WeatherApi
import com.nicname.iyeongjun.gwangju_contest.api.model.rent.RentModel
import com.nicname.iyeongjun.gwangju_contest.api.model.storage.StorageModel
import com.nicname.iyeongjun.gwangju_contest.api.model.weather.WeatherModel
import com.nicname.iyeongjun.gwangju_contest.ui.activities.splash.SplashViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Named


@Module
class SplashModule{

    @Provides
    fun provideSplashViewModelFactory(weatherApi : WeatherApi,
                                      tourApi: TourApi,
                                      weatherDriver : BehaviorSubject<WeatherModel>,
                                      rentModel: RentModel,
                                      @Named("merged") storageModel : StorageModel)
            = SplashViewModelFactory(weatherApi,tourApi,weatherDriver,rentModel,storageModel)
}