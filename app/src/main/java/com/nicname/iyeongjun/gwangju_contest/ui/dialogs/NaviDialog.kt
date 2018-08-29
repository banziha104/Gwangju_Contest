package com.nicname.iyeongjun.gwangju_contest.ui.dialogs

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.Window
import com.nicname.iyeongjun.gwangju_contest.R
import com.nicname.iyeongjun.gwangju_contest.R.id.*
import com.nicname.iyeongjun.gwangju_contest.adapter.recycler.NaviAdapter
import com.skt.Tmap.TMapData
import kotlinx.android.synthetic.main.dialog_navi.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class NaviDialog(var activity: Activity?) : Dialog(activity), View.OnClickListener, AnkoLogger {
    val data = TMapData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_navi)

        btnNavi.setOnClickListener {

        }

        btnNavi.setOnClickListener {view ->
            data.findAddressPOI(h.text.toString()){
                activity!!.runOnUiThread {
                    naviRecyclerview.apply {
                        adapter = NaviAdapter(activity!!,it)
                        layoutManager = LinearLayoutManager(activity)
                        adapter.notifyDataSetChanged()
                        addItemDecoration(DividerItemDecoration(activity, 1))
                    }
                }
                info { "${h.text} / ${it.size}" }
            }
        }
    }

    override fun onClick(v: View) {
        dismiss()
    }
}