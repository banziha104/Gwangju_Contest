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
import okhttp3.Call
import okhttp3.Callback
import okhttp3.ResponseBody
import org.json.XML
import retrofit2.Response


class SplashActivity : DaggerAppCompatActivity(), AnkoLogger, PermissionController.CallBack {
    private val REQ_PERMISSION = 100 // 권한요청코드
    @Inject
    lateinit var viewModelFactory: SplashViewModelFactory
    lateinit var viewModel: SplashViewModel
    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        PermissionController(this,
                arrayOf(Manifest.permission.INTERNET,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.CAMERA)).checkVersion()
    }

    override fun init() {
        info { "init 스타트" }
        lifecycle += disposable
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[SplashViewModel::class.java]
        viewDisposables += viewModel
                .weatherApi
                .getWeather("35.158829", "126.852053")
                .subscribe({
                    viewModel.weatherDriver.onNext(it)
                    info { viewModel.storageModel }
                    info { viewModel.storageModel.items.size }
                    startActivity<MainActivity>()
                }, { it.printStackTrace() })

        viewDisposables += viewModel
                .tourApi
                .getTourData()
                .subscribe({
                    info { "야야아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ ${it.body?.items?.size}" }
                    info { it.body?.items!![0].title }
                    info { it.body?.items!![1].title }
                    info { it.body?.items!![2].title }
                },{
                    it.printStackTrace()
                })
        //                .enqueue(object : retrofit2.Callback<ResponseBody>{
//                    override fun onFailure(call: retrofit2.Call<ResponseBody>?, t: Throwable?) {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                    }
//
//                    override fun onResponse(call: retrofit2.Call<ResponseBody>?, response: Response<ResponseBody>?) {
//                        info { response?.body()?.string() }
//                    }
//
//                })
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PermissionController.REQ_FLAG) {
            if (PermissionController.onCheckResult(grantResults)) {
                info { "사용자 확정" }
                init()
            } else {
                Toast.makeText(this, "권한을 허용하지 않으시면 프로그램을 실행할 수 없습니다.", Toast.LENGTH_LONG).show()
            }
        }
    }
}