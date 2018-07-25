package com.nicname.iyeongjun.gwangju_contest.di.mod.activites

import com.nicname.iyeongjun.gwangju_contest.di.mod.activites.mod.MainModule
import com.nicname.iyeongjun.gwangju_contest.di.mod.activites.mod.SplashModule
import com.nicname.iyeongjun.gwangju_contest.ui.activities.main.MainActivity
import com.nicname.iyeongjun.gwangju_contest.ui.activities.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder{
    @ContributesAndroidInjector(modules = arrayOf(SplashModule::class))
    abstract fun bindSplash() : SplashActivity

    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMain() : MainActivity
}