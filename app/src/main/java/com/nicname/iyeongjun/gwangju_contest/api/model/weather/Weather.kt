package com.nicname.iyeongjun.gwangju_contest.api.model.weather

import com.google.gson.annotations.SerializedName
data class Weather(
    @SerializedName("hourly") val hourly: List<Hourly?>?
)