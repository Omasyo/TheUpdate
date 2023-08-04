package com.keetr.theupdate.data

data class Article(
    val id: String,
    val author: String,
//    val authors: String,
    val cleanUrl: String,
    val excerpt: String,
    val link: String,
    val mediaUrl: String,
    val publishedDate: String,
    val summary: String,
    val title: String,
    val topic: Topic
)
