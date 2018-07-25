package com.nicname.iyeongjun.gwangju_contest.di.mod.global

import com.google.gson.Gson
import com.nicname.iyeongjun.gwangju_contest.api.data.bikeRentLocationData
import com.nicname.iyeongjun.gwangju_contest.api.model.rent.RentModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalModule{
    @Singleton
    @Provides
    fun provideRentModel(gson : Gson) = gson.fromJson(bikeRentLocationData,RentModel::class.java)


    @Singleton
    @Provides
    fun provideGson() = Gson()
}