package com.nicname.iyeongjun.gwangju_contest.ui.fragments.ride

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class RideViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RideViewModel() as T
    }
}