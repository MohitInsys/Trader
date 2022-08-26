package com.example.trader.retrofitForDiscover

import com.google.gson.annotations.SerializedName


data class DiscoverApiData(
    val count: Int,
    val gender: Any,
    val name: String,
    val probability: Float
)