package com.nicname.iyeongjun.gwangju_contest.di

import android.content.Context
import com.nicname.iyeongjun.gwangju_contest.GwangjuApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class))
interface AppComponent : AndroidInjector<GwangjuApplication> {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(app : Context) : Builder
        fun build() : AppComponent
    }
}