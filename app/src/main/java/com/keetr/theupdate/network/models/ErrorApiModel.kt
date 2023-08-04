package com.keetr.theupdate.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorApiModel(
    @SerialName("error_code") val errorCode: String,
    @SerialName("message") val message: String,
    @SerialName("status") val status: String
)