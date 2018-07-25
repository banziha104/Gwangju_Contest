package com.nicname.iyeongjun.gwangju_contest.api.model.rent

import com.google.gson.annotations.SerializedName

data class RentModel(
    @SerializedName("items") val items: List<Item?>?
)