package com.keetr.theupdate.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleApiModel(
    @SerialName("author") val author: String,
    @SerialName("authors") val authors: String,
    @SerialName("clean_url") val cleanUrl: String,
    @SerialName("country") val country: String,
    @SerialName("excerpt") val excerpt: String?,
    @SerialName("_id") val id: String,
    @SerialName("is_opinion") val isOpinion: Boolean,
    @SerialName("language") val language: String?,
    @SerialName("link") val link: String,
    @SerialName("media") val media: String?,
    @SerialName("published_date") val publishedDate: String,
    @SerialName("published_date_precision") val publishedDatePrecision: String,
    @SerialName("rank") val rank: Int,
    @SerialName("rights") val rights: String,
    @SerialName("_score") val score: Double?,
    @SerialName("summary") val summary: String,
    @SerialName("title") val title: String,
    @SerialName("topic") val topic: String?,
    @SerialName("twitter_account") val twitterAccount: String?
)