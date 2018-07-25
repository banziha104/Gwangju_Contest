package com.nicname.iyeongjun.gwangju_contest.api.model.weather

import com.google.gson.annotations.SerializedName
data class Common(
    @SerializedName("alertYn") val alertYn: String?,
    @SerializedName("stormYn") val stormYn: String?
)