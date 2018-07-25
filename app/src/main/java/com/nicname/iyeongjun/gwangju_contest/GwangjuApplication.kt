package com.nicname.iyeongjun.gwangju_contest

import com.nicname.iyeongjun.gwangju_contest.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class GwangjuApplication : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
//    override fun onCreate() {
//        super.onCreate()
//        Iconify.with(FontAwesomeModule())
//    }
}