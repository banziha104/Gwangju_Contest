package com.nicname.iyeongjun.gwangju_contest.ui.fragments.tour



import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicname.iyeongjun.gwangju_contest.R
import com.nicname.iyeongjun.gwangju_contest.adapter.recycler.TourAdatper
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_tour.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class TourFragment : DaggerFragment(), AnkoLogger {
    @Inject lateinit var viewModelFactory: TourViewModelFactory
    lateinit var viewModel : TourViewModel
    var tourTabLayout : TabLayout? = null
    companion object {
        private const val VERTICAL = 1
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tour, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[TourViewModel::class.java]
        tourTabLayout = view.findViewById(R.id.tourTab) as TabLayout
        for(i in 0..5) { tourTabLayout!!.addTab(tourTabLayout!!.newTab().setText(viewModel.type[i])) }
        return view
    }

    override fun onResume() {
        super.onResume()
        viewModel.api
                .getTourData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    info {  it.body.items.size }
                    tourRecycler.apply {
                        adapter = TourAdatper(it,activity!! as AppCompatActivity)
                        layoutManager = LinearLayoutManager(activity)
                    }
                },{
                    it.printStackTrace()
                })
    }
}
