package com.nicname.iyeongjun.gwangju_contest.ui.fragments.ride

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.nicname.iyeongjun.gwangju_contest.R
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class RideFragment : DaggerFragment() {
    @Inject lateinit var viewModelFactory: RideViewModelFactory
    lateinit var viewModel: RideViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProviders.of(this, viewModelFactory)[RideViewModel::class.java]

        return inflater.inflate(R.layout.fragment_ride, container, false)
    }

}
