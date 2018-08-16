package com.nicname.iyeongjun.gwangju_contest.ui.fragments.tour

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nicname.iyeongjun.gwangju_contest.api.inter.TourApi

class TourViewModelFactory(val api : TourApi) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TourViewModel(api) as T
    }
}