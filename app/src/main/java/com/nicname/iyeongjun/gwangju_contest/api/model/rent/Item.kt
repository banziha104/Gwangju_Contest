package com.nicname.iyeongjun.gwangju_contest.api.model.rent

import com.google.gson.annotations.SerializedName
data class Item(
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("location_oad") val locationOad: String,
    @SerializedName("location") val location: String,
    @SerializedName("lat") val lat: String,
    @SerializedName("lon") val lon: String,
    @SerializedName("start_time") val startTime: String,
    @SerializedName("end_time") val endTime: String,
    @SerializedName("holiyday") val holiyday: String,
    @SerializedName("price_type") val priceType: String,
    @SerializedName("price") val price: String,
    @SerializedName("quantity_bike") val quantityBike: String,
    @SerializedName("quantity_holder") val quantityHolder: String,
    @SerializedName("airpressier") val airpressier: String,
    @SerializedName("airpressier_type") val airpressierType: String,
    @SerializedName("fix_facility") val fixFacility: String,
    @SerializedName("call") val call: String,
    @SerializedName("organ") val organ: String,
    @SerializedName("create_at") val createAt: String,
    @SerializedName("province") val province: String
)