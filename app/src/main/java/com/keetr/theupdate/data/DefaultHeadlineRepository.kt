package com.keetr.theupdate.data

import com.keetr.theupdate.data.mapper.toArticle
import com.keetr.theupdate.network.NewsDatasource
import com.keetr.theupdate.network.Success

class DefaultHeadlineRepository(val networkDatasource: NewsDatasource) : HeadlineRepository {
    override suspend fun fetchLatestHeadlines(page: Int): List<Article> {
        val response = networkDatasource.fetchLatestHeadlines(
            duration = "",
            lang = listOf(),
            notLang = listOf(),
            countries = listOf(),
            notCountries = listOf(),
            topic = "",
            sources = listOf(),
            notSources = listOf(),
            rankedOnly = true,
            pageSize = 10,
            page = page
        )
        return (response as Success).data.articles.map { it.toArticle() }
    }
}