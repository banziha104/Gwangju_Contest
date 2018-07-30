package com.nicname.iyeongjun.gwangju_contest.di

import android.content.Context
import com.nicname.iyeongjun.gwangju_contest.GwangjuApplication
import com.nicname.iyeongjun.gwangju_contest.di.mod.global.ApiModule
import com.nicname.iyeongjun.gwangju_contest.di.mod.activites.ActivityBinder
import com.nicname.iyeongjun.gwangju_contest.di.mod.fragments.FragmentBinder
import com.nicname.iyeongjun.gwangju_contest.di.mod.global.DriverModule
import com.nicname.iyeongjun.gwangju_contest.di.mod.global.LocalModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        FragmentBinder::class,
        ActivityBinder::class,
        ApiModule::class,
        LocalModule::class,
        DriverModule::class
        ))
interface AppComponent : AndroidInjector<GwangjuApplication> {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(app : Context) : Builder
        fun build() : AppComponent
    }
}