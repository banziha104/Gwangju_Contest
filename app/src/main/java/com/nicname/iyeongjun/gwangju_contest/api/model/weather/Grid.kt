package com.nicname.iyeongjun.gwangju_contest.api.model.weather

import com.google.gson.annotations.SerializedName
data class Grid(
    @SerializedName("latitude") val latitude: String?,
    @SerializedName("longitude") val longitude: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("county") val county: String?,
    @SerializedName("village") val village: String?
)