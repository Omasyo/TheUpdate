package com.keetr.theupdate.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LatestHeadlinesApiModel(
    @SerialName("articles") val articles: List<ArticleApiModel>,
    @SerialName("page") val page: Int,
    @SerialName("page_size") val pageSize: Int,
    @SerialName("status") val status: String,
    @SerialName("total_hits") val totalHits: Int,
    @SerialName("total_pages") val totalPages: Int,
    @SerialName("user_input") val userInput: UserInputApiModel
)