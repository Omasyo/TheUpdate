package com.keetr.theupdate.data.mapper

import com.keetr.theupdate.data.Article
import com.keetr.theupdate.data.Topic
import com.keetr.theupdate.network.models.ArticleApiModel

fun List<ArticleApiModel>.toArticles() = map { apiModel -> apiModel.toArticle() }

fun ArticleApiModel.toArticle() = Article(
    id = id,
    author = author,
    cleanUrl = cleanUrl,
    excerpt = excerpt ?: "",
    link = link,
    mediaUrl = media,
    publishedDate = publishedDate,
    summary = summary,
    title = title,
    topic = Topic.from(topic ?: "")

)