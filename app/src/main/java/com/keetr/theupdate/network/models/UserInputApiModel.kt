package com.keetr.theupdate.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserInputApiModel(
    @SerialName("countries") val countries: List<String>?,
    @SerialName("from") val from: String,
    @SerialName("lang") val lang: List<String>?,
    @SerialName("not_countries") val notCountries: List<String>?,
    @SerialName("not_lang") val notLang: List<String>?,
    @SerialName("not_sources") val notSources: List<String>?,
    @SerialName("page") val page: Int,
    @SerialName("size") val size: Int,
    @SerialName("sources") val sources: List<String>?,
    @SerialName("topic") val topic: String?
)