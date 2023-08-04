package com.keetr.theupdate.network

import com.keetr.theupdate.network.models.LatestHeadlinesApiModel

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
        rankedOnly: Boolean,
        pageSize: Int,
        page: Int,
    ) : Response<LatestHeadlinesApiModel>
}