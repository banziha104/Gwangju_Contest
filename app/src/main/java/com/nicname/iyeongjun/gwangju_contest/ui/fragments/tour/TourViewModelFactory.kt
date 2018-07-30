package com.nicname.iyeongjun.gwangju_contest.ui.fragments.tour

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class TourViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TourViewModel() as T
    }
}