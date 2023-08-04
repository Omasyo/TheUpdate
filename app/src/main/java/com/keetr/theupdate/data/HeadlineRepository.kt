package com.keetr.theupdate.data

interface HeadlineRepository {
    suspend fun fetchLatestHeadlines(page: Int): List<Article>
}