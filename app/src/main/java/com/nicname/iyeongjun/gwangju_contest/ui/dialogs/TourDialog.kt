package com.nicname.iyeongjun.gwangju_contest.ui.dialogs

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import com.nicname.iyeongjun.gwangju_contest.GlideApp
import com.nicname.iyeongjun.gwangju_contest.R
import com.nicname.iyeongjun.gwangju_contest.api.model.tour.TourModel2
import com.nicname.iyeongjun.gwangju_contest.extension.convertType
import com.nicname.iyeongjun.gwangju_contest.extension.getTourToDate
import kotlinx.android.synthetic.main.dialog_tour.*

class TourDialog(var activity: Activity?, val item : TourModel2.BodyBean.ItemBean) : Dialog(activity), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_tour)
        txtDiaTourCreated.text = " 생성일 : ${item.createdtime.getTourToDate()}"
        txtDiaTourUpdate.text = " 수정일 : ${item.modifiedtime.getTourToDate()}"
        txtDiaTourLocation.text = " 주소 : ${item.addr1}"
        txtDiaTourType.text = " 타입 : ${item.contenttypeid.convertType()}"
        txtDiaTourTitle.text = item.title

        if(item.firstimage != null && item.firstimage != ""){
            GlideApp
                    .with(context)
                    .load(item.firstimage)
                    .into(imgDiaTour)
        }else{
            GlideApp
                    .with(context)
                    .load(R.drawable.default_tour_img)
                    .into(imgDiaTour)
        }
    }

    override fun onClick(v: View) {
        dismiss()
    }
}