package com.nicname.iyeongjun.gwangju_contest.ui.fragments.weather

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicname.iyeongjun.gwangju_contest.R
import com.nicname.iyeongjun.gwangju_contest.adapter.recycler.WeatherAdapter
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_weather.*
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject



class WeatherFragment : DaggerFragment(), AnkoLogger {

    @Inject
    lateinit var viewModelFactory: WeatherViewModelFactory
    lateinit var viewModel: WeatherViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProviders.of(this, viewModelFactory)[WeatherViewModel::class.java]
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onResume() {
        super.onResume()
        viewModel.driver
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    txtWeatherAver.text = "${it.weather!!.hourly!![0]!!.temperature!!.tc!!.toDouble().toInt()}°"
                    txtWeatherMinmax.text = "최고 ${it.weather!!.hourly!![0]!!.temperature!!.tmax!!.toDouble().toInt()} / 최저 ${it.weather!!.hourly!![0]!!.temperature!!.tmin!!.toDouble().toInt()}"
                }, {
                    it.printStackTrace()
                })

        weatherRecycler.apply {
            adapter = WeatherAdapter(activity!!)
            layoutManager = LinearLayoutManager(activity!!)
        }
    }
}
