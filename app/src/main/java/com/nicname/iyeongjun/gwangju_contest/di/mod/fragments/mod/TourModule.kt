package com.nicname.iyeongjun.gwangju_contest.di.mod.fragments.mod

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nicname.iyeongjun.gwangju_contest.api.inter.TourApi
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.tour.TourViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TourModule{
    @Provides
    fun provideTourViewModelFactory(api : TourApi) = TourViewModelFactory(api)
}