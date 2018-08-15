package com.nicname.iyeongjun.gwangju_contest.ui.fragments.tour

import android.arch.lifecycle.ViewModel
<<<<<<< HEAD

class TourViewModel : ViewModel()
=======
import com.nicname.iyeongjun.gwangju_contest.api.inter.TourApi
import com.nicname.iyeongjun.gwangju_contest.api.model.tour.TourModel
import com.nicname.iyeongjun.gwangju_contest.api.model.tour.TourModel2
import io.reactivex.subjects.BehaviorSubject

class TourViewModel(val api : TourApi) : ViewModel(){
    val type = listOf("관광","문화","행사","숙박","쇼핑","음식점")
    val driver = BehaviorSubject.createDefault("")
}
>>>>>>> add AR
