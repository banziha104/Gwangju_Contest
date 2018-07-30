package com.nicname.iyeongjun.gwangju_contest.di.mod.fragments.mod

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.tour.TourViewModel
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.tour.TourViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class TourModule{
    @Provides
    fun provideTourViewModelFactory() = TourViewModelFactory()
}