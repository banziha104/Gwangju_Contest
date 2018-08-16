package com.nicname.iyeongjun.gwangju_contest.ui.fragments.storage

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
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
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign
import com.nicname.iyeongjun.gwangju_contest.util.ar.ARActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_rent.*
import kotlinx.android.synthetic.main.fragment_storage.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.find
import org.jetbrains.anko.info
import org.jetbrains.anko.startActivity
import javax.inject.Inject


class StorageFragment : DaggerFragment(), OnMapReadyCallback,AnkoLogger {
    @Inject
    lateinit var viewModelFactory: StorageViewModelFactory
    lateinit var viewModel : StorageViewModel
    var map : MapView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_storage, container, false)
        map = view.findViewById(R.id.storageMap)
        map?.onCreate(savedInstanceState)
        map?.getMapAsync(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[StorageViewModel::class.java]
        return view
    }

    override fun onMapReady(map: GoogleMap?) {
        val location = LatLng(35.161683, 126.872869)
        map?.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14.5f))
        for (i in viewModel.storageModel.items) {
            try {
                val tempLocation = LatLng(i.lat.toDouble(), i.lan.toDouble())
                val maker = MarkerOptions()
                        .position(tempLocation)
                        .title(i.name)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.park_pin))
                map?.addMarker(maker)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    override fun onResume() {
        super.onResume()
        map?.onResume()
        btnStorageAr.setOnClickListener {
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
