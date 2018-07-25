package com.nicname.iyeongjun.gwangju_contest.ui.activities.splash

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nicname.iyeongjun.gwangju_contest.R
import com.nicname.iyeongjun.gwangju_contest.rx.AutoClearedDisposable
import com.nicname.iyeongjun.gwangju_contest.util.plusAssign
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity(), AnkoLogger {
    @Inject lateinit var viewModelFactory: SplashViewModelFactory
    lateinit var viewModel: SplashViewModel
    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lifecycle += disposable
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[SplashViewModel::class.java]
        viewDisposables += viewModel
                .weatherApi
                .getWeather("37.453973", "127.127015")
                .subscribe({
                    viewModel.weatherDriver.onNext(it)
                    info { viewModel.storageModel }
                    info { viewModel.storageModel.items.size}
                }, { it.printStackTrace() })
    }
}
