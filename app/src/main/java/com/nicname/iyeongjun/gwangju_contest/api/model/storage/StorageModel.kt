package com.nicname.iyeongjun.gwangju_contest.api.model.storage

import com.google.gson.annotations.SerializedName

data class StorageModel(
    @SerializedName("items") val items: List<Item>
)