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
<<<<<<< HEAD

import com.nicname.iyeongjun.gwangju_contest.R
import com.nicname.iyeongjun.gwangju_contest.R.id.button
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign
import com.nicname.iyeongjun.gwangju_contest.rx.AutoClearedDisposable
=======
import com.jakewharton.rxbinding2.view.clicks

import com.nicname.iyeongjun.gwangju_contest.R
import com.nicname.iyeongjun.gwangju_contest.api.ArData
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign
import com.nicname.iyeongjun.gwangju_contest.rx.AutoClearedDisposable
import com.nicname.iyeongjun.gwangju_contest.util.ar.ARActivity
>>>>>>> add AR
import dagger.android.support.DaggerFragment
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.fragment_rent.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
<<<<<<< HEAD
=======
import org.jetbrains.anko.startActivity
>>>>>>> add AR
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
<<<<<<< HEAD
=======
        ArData.rentData = viewModel.rentModel
>>>>>>> add AR
        return view
    }


    override fun onMapReady(map: GoogleMap?) {
//        eventDriver.subscribe {
<<<<<<< HEAD
            if (flag == RENT_MODE) {
                val location = LatLng(35.161683, 126.872869)
                map?.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14.5f))
                for (i in viewModel.rentModel.items) {
                    val tempLocation = LatLng(i.lat.toDouble(), i.lon.toDouble())
                    val maker = MarkerOptions()
                            .position(tempLocation)
                            .title(i.name)
                    map?.addMarker(maker)
                }
            }
        }
=======
        if (flag == RENT_MODE) {
            val location = LatLng(35.161683, 126.872869)
            map?.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14.5f))
            for (i in viewModel.rentModel.items) {
                val tempLocation = LatLng(i.lat.toDouble(), i.lon.toDouble())
                val maker = MarkerOptions()
                        .position(tempLocation)
                        .title(i.name)
                map?.addMarker(maker)
            }
        }
    }
>>>>>>> add AR


    override fun onResume() {
        super.onResume()
        map?.onResume()
<<<<<<< HEAD
=======
        btnRentAr.setOnClickListener {
            activity!!.startActivity<ARActivity>()
        }
>>>>>>> add AR
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
