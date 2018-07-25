package com.nicname.iyeongjun.gwangju_contest.api.model.weather

import com.google.gson.annotations.SerializedName
data class Temperature(
    @SerializedName("tc") val tc: String?,
    @SerializedName("tmax") val tmax: String?,
    @SerializedName("tmin") val tmin: String?
)