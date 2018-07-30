package com.nicname.iyeongjun.gwangju_contest.ui.activities.main

import android.arch.lifecycle.ViewModel
import android.support.v4.app.Fragment
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.rent.RentFragment
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.ride.RideFragment
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.tour.TourFragment

class MainViewModel : ViewModel(){
    fun getFragments() : List<Fragment>{
        return listOf(RentFragment(),RideFragment(),TourFragment())
    }
}