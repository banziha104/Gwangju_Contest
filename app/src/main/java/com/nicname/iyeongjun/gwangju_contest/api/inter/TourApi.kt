package com.nicname.iyeongjun.gwangju_contest.api.inter

import com.nicname.iyeongjun.gwangju_contest.api.model.tour.TourModel
import com.nicname.iyeongjun.gwangju_contest.api.model.tour.TourModel2
import com.nicname.iyeongjun.gwangju_contest.const.API_KEY
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TourApi{
    @GET("openapi/service/rest/KorService/locationBasedList")
    fun getTourData(
            @Query("numOfRows") numOfRows : Int = 100,
            @Query("pageNo") pageNo : Int = 1,
            @Query("MobileOS") mobileOs : String = "AND",
            @Query("MobileApp") mobileApp : String = "Gwangju",
            @Query("ServiceKey", encoded = true) serviceKey : String = API_KEY,
            @Query("mapX") lon : Double = 126.872869,
            @Query("mapY") lat : Double = 35.161683,
            @Query("radius") radius : Int = 50000
    ) : Observable<TourModel>
}