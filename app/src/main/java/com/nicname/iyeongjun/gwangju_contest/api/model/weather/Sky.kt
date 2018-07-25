package com.nicname.iyeongjun.gwangju_contest.api.model.weather

import com.google.gson.annotations.SerializedName
data class Sky(
    @SerializedName("code") val code: String?,
    @SerializedName("name") val name: String?
)