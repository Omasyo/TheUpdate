package com.keetr.theupdate.network

import com.keetr.theupdate.network.models.LatestHeadlinesApiModel
import io.ktor.client.HttpClient

interface NewsDatasource {
    suspend fun fetchLatestHeadlines(
        duration: String,
        lang: List<String>,
        notLang: List<String>,
        countries: List<String>,
        notCountries: List<String>,
        topic: String,
        sources: List<String>,
        notSources: List<String>,
        ranked: Boolean,
        pageSize: Int,
        page: Int,
    ) : Response<LatestHeadlinesApiModel>
}