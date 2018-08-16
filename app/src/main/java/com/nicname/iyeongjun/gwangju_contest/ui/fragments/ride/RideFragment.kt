package com.nicname.iyeongjun.gwangju_contest.ui.fragments.ride

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.nicname.iyeongjun.gwangju_contest.R
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign
import com.nicname.iyeongjun.gwangju_contest.ui.dialogs.NaviDialog
import com.skt.Tmap.TMapData
import dagger.android.support.DaggerFragment
import io.nlopez.smartlocation.SmartLocation
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_ride.*
import org.jetbrains.anko.AnkoLogger
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RideFragment : DaggerFragment() , AnkoLogger {
    @Inject lateinit var viewModelFactory: RideViewModelFactory
    lateinit var viewModel: RideViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProviders.of(this, viewModelFactory)[RideViewModel::class.java]

        return inflater.inflate(R.layout.fragment_ride, container, false)
    }

    override fun onResume() {
        super.onResume()

        txtRideCal.text = "0"
        txtRideDistance.text = "0m"
        txtRideEtc.text = "더보기"
        txtRideRain.text = "60%"
        txtRideLocation.text = "서구 치평동"
        txtRideScore.text = "35점"
        txtRideTempature.text = "$0°"
        txtRideTime.text = "0분 / 0초"
        txtRideSpeed.text = "0"

        viewModel.api.getWeather("35.158829", "126.852053")
        .subscribe({
            SmartLocation.with(activity!!).location().start{ location ->
                try {
                    txtRideCal.text = "${0.0}"
                    txtRideDistance.text = "${0}m"
                    txtRideEtc.text = "더보기"
                    txtRideRain.text = "60%"
                    txtRideLocation.text = "서구 치평동"
                    txtRideScore.text = "35점"
                    txtRideTempature.text = "${it.weather!!.hourly!![0]!!.temperature!!.tc!!.toDouble().toInt()}°"
                    txtRideTime.text = "0분 / 0초"
                    txtRideSpeed.text = "${location.speed}"
                } catch (e : Exception){
                    e.printStackTrace()
                }
            }
        },{
            it.printStackTrace()
        })

        btnRideNavi.setOnClickListener {
            val dialog = NaviDialog(activity!!)
            dialog!!.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }

        btnRideStart.setOnClickListener {
            Observable.interval(1,TimeUnit.SECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                var sec = it % 60
                var min = (it / 60).toInt()
                txtRideTime.text = "${min}분 ${sec}초"
            },{
                it.printStackTrace()
            })
        }
    }
}
