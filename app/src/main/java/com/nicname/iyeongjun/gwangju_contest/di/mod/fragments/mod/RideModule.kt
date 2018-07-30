package com.nicname.iyeongjun.gwangju_contest.di.mod.fragments.mod

import com.nicname.iyeongjun.gwangju_contest.ui.fragments.ride.RideViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class RideModule{
    @Provides
    fun provideRideViewModelFactory() = RideViewModelFactory()
}