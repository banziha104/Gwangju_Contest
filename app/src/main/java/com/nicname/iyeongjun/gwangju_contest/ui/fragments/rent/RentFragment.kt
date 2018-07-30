package com.nicname.iyeongjun.gwangju_contest.ui.fragments.rent


import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import com.nicname.iyeongjun.gwangju_contest.R
import com.nicname.iyeongjun.gwangju_contest.R.id.button
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign
import com.nicname.iyeongjun.gwangju_contest.rx.AutoClearedDisposable
import dagger.android.support.DaggerFragment
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.fragment_rent.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class RentFragment : DaggerFragment(), OnMapReadyCallback, AnkoLogger {
    companion object {
        const val RENT_MODE = true
        const val STORAGE_MODE = false
    }

    @Inject
    lateinit var viewModelFactory: RentViewModelFactory
    lateinit var viewModel: RentViewModel
    val eventDriver = BehaviorSubject.createDefault<Boolean>(RENT_MODE)
    var map: MapView? = null
    var flag = RENT_MODE

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_rent, container, false)
        map = view.findViewById(R.id.mapView) as MapView
        map?.onCreate(savedInstanceState)
        map?.getMapAsync(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[RentViewModel::class.java]
        return view
    }


    override fun onMapReady(map: GoogleMap?) {
//        eventDriver.subscribe {
            if (flag == RENT_MODE) {
                map?.clear()
                val location = LatLng(35.161683, 126.872869)
                map?.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14.5f))
                for (i in viewModel.storageModel.items) {
                    try {
                        val tempLocation = LatLng(i.lat.toDouble(), i.lan.toDouble())
                        val maker = MarkerOptions()
                                .position(tempLocation)
                                .title(i.name)
                        map?.addMarker(maker)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            } else {
                map?.clear()
                info { viewModel.rentModel.items.size }
                for (i in viewModel.rentModel.items) {
                    val tempLocation = LatLng(i.lat.toDouble(), i.lon.toDouble())
                    val maker = MarkerOptions()
                            .position(tempLocation)
                            .title(i.name)
                    map?.addMarker(maker)
                }
//            }
        }
    }

    override fun onResume() {
        super.onResume()
        map?.onResume()
        button.setOnClickListener { eventDriver.onNext(!flag) }
    }

    override fun onDestroy() {
        super.onDestroy()
        map?.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        map?.onLowMemory()
    }
}
