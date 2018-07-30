package com.nicname.iyeongjun.gwangju_contest.di.mod.fragments

import com.nicname.iyeongjun.gwangju_contest.di.mod.fragments.mod.*
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.rent.RentFragment
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.ride.RideFragment
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.storage.StorageFragment
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.tour.TourFragment
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.weather.WeatherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBinder{
    @ContributesAndroidInjector(modules = arrayOf(RentModule::class))
    abstract fun bindRentModule() : RentFragment

    @ContributesAndroidInjector(modules = arrayOf(TourModule::class))
    abstract fun bindTourModule() : TourFragment

    @ContributesAndroidInjector(modules = arrayOf(RideModule::class))
    abstract fun bindRideModule() : RideFragment

    @ContributesAndroidInjector(modules = arrayOf(WeatherModule::class))
    abstract fun bindWeatherModule() : WeatherFragment

    @ContributesAndroidInjector(modules = arrayOf(StorageModule::class))
    abstract fun bindStorageModule() : StorageFragment
}