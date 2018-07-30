package com.nicname.iyeongjun.gwangju_contest.ui.activities.main

import android.arch.lifecycle.ViewModel
import android.support.v4.app.Fragment
import com.nicname.iyeongjun.gwangju_contest.di.mod.fragments.mod.StorageModule
import com.nicname.iyeongjun.gwangju_contest.di.mod.fragments.mod.WeatherModule
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.rent.RentFragment
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.ride.RideFragment
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.storage.StorageFragment
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.tour.TourFragment
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.weather.WeatherFragment

class MainViewModel : ViewModel(){
    fun getFragments() : List<Fragment>{
        return listOf(RentFragment(),StorageFragment(),RideFragment(),WeatherFragment(),TourFragment())
    }
}