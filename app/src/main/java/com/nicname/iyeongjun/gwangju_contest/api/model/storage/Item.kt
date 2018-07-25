package com.nicname.iyeongjun.gwangju_contest.api.model.storage

import com.google.gson.annotations.SerializedName
data class Item(
    @SerializedName("name") val name: String,
    @SerializedName("location_road") val locationRoad: String,
    @SerializedName("location") val location: String,
    @SerializedName("lat") val lat: String,
    @SerializedName("lan") val lan: String,
    @SerializedName("quantity") val quantity: String,
    @SerializedName("year") val year: String,
    @SerializedName("type") val type: String,
    @SerializedName("aminion") val aminion: String,
    @SerializedName("air_pressure") val airPressure: String,
    @SerializedName("air_type") val airType: String,
    @SerializedName("facilty_fix") val faciltyFix: String,
    @SerializedName("call") val call: String,
    @SerializedName("organ") val organ: String,
    @SerializedName("create_at") val createAt: String,
    @SerializedName("province") val province: String
)