package com.nicname.iyeongjun.gwangju_contest.di.mod.fragments.mod

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
<<<<<<< HEAD
=======
import com.nicname.iyeongjun.gwangju_contest.api.inter.TourApi
>>>>>>> add AR
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.tour.TourViewModel
import com.nicname.iyeongjun.gwangju_contest.ui.fragments.tour.TourViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class TourModule{
    @Provides
<<<<<<< HEAD
    fun provideTourViewModelFactory() = TourViewModelFactory()
=======
    fun provideTourViewModelFactory(api : TourApi) = TourViewModelFactory(api)
>>>>>>> add AR
}