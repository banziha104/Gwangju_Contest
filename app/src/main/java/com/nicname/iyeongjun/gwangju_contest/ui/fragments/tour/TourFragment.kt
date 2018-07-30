package com.nicname.iyeongjun.gwangju_contest.ui.fragments.tour


import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.nicname.iyeongjun.gwangju_contest.R
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TourFragment : DaggerFragment() {
    @Inject lateinit var viewModelFactory: TourViewModelFactory
    lateinit var viewModel: TourViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProviders.of(this, viewModelFactory)[TourViewModel::class.java]

        return inflater.inflate(R.layout.fragment_tour, container, false)
    }


}
