package com.nicname.iyeongjun.gwangju_contest.ui.fragments.rent

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.nicname.iyeongjun.gwangju_contest.R
import com.nicname.iyeongjun.gwangju_contest.api.ArData
import com.nicname.iyeongjun.gwangju_contest.util.ar.ARActivity
import dagger.android.support.DaggerFragment
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.fragment_rent.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
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
        ArData.rentData = viewModel.rentModel
        return view
    }


    override fun onMapReady(map: GoogleMap?) {
//        eventDriver.subscribe {
        if (flag == RENT_MODE) {
            val location = LatLng(35.161683, 126.872869)
            map?.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14.5f))
            for (i in viewModel.rentModel.items) {
                val tempLocation = LatLng(i.lat.toDouble(), i.lon.toDouble())
                val maker = MarkerOptions()
                        .position(tempLocation)
                        .title(i.name)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.rent_pin))
                map?.addMarker(maker)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        map?.onResume()
        btnRentAr.setOnClickListener {
            activity!!.startActivity<ARActivity>()
        }
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
