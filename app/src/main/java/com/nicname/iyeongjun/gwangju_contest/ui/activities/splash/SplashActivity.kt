package com.nicname.iyeongjun.gwangju_contest.ui.activities.splash

import android.Manifest
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.content.PermissionChecker
import com.nicname.iyeongjun.gwangju_contest.R
import com.nicname.iyeongjun.gwangju_contest.rx.AutoClearedDisposable
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign
import com.nicname.iyeongjun.gwangju_contest.ui.activities.main.MainActivity
import com.nicname.iyeongjun.gwangju_contest.util.PermissionController
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.startActivity
import javax.inject.Inject
import android.widget.Toast


class SplashActivity : DaggerAppCompatActivity(), AnkoLogger, PermissionController.CallBack {
    private val REQ_PERMISSION = 100 // 권한요청코드
    @Inject
    lateinit var viewModelFactory: SplashViewModelFactory
    lateinit var viewModel: SplashViewModel
    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)
    var permissionController: PermissionController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        permissionController = PermissionController(this,
                arrayOf(Manifest.permission.INTERNET,
                        Manifest.permission.ACCESS_FINE_LOCATION))
        permissionController?.checkVersion()
    }

    override fun init() {
        info { "init 스타트" }
        lifecycle += disposable
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[SplashViewModel::class.java]
        viewDisposables += viewModel
                .weatherApi
                .getWeather("35.166401", "126.843347")
                .subscribe({
                    viewModel.weatherDriver.onNext(it)
                    info { viewModel.storageModel }
                    info { viewModel.storageModel.items.size }
                    startActivity<MainActivity>()
                }, { it.printStackTrace() })
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQ_PERMISSION) {
            if (permissionController!!.onCheckResult(grantResults)) {
                init()
            } else {
                Toast.makeText(this, "권한을 허용하지 않으시면 프로그램을 실행할 수 없습니다.", Toast.LENGTH_LONG).show()
            }
        }
    }
}