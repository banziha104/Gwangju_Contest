package com.nicname.iyeongjun.gwangju_contest.ui.activities.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import com.nicname.iyeongjun.gwangju_contest.R
import com.nicname.iyeongjun.gwangju_contest.api.inter.WeatherApi
import com.nicname.iyeongjun.gwangju_contest.const.T_BASE_URL
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign
import com.nicname.iyeongjun.gwangju_contest.rx.AutoClearedDisposable
import com.nicname.iyeongjun.nonglim.adapter.pager.MainPagerAdapter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(),AnkoLogger {

    @Inject lateinit var viewModelFactory: MainViewModelFactory
    lateinit var viewModel : MainViewModel
    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this,alwaysClearOnStop = false)
    val tabNames = arrayOf("대여소", "라이딩", "관광정보")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
        bind(viewModel.getFragments())
    }
    private fun bind(list : List<Fragment>) {
        mainViewpager.adapter = MainPagerAdapter(supportFragmentManager, list)
        for (i in 0..2) tab.addTab(tab.newTab().setText(tabNames[i]))
        mainViewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab))
        tab.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(mainViewpager))
        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tabs: TabLayout.Tab) {

            }

            override fun onTabUnselected(tabs: TabLayout.Tab) {

            }

            override fun onTabReselected(tabs: TabLayout.Tab) {

            }
        })
    }
}

