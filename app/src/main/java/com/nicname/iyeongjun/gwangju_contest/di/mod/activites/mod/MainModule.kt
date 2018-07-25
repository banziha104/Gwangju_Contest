package com.nicname.iyeongjun.gwangju_contest.di.mod.activites.mod

import com.nicname.iyeongjun.gwangju_contest.ui.activities.main.MainViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MainModule{
    @Provides
    fun provideMainViewModelFactory() = MainViewModelFactory()
}