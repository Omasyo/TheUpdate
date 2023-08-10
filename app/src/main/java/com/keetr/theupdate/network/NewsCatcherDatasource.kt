package com.keetr.theupdate.network

import android.util.Log
import com.keetr.theupdate.network.models.ErrorApiModel
import com.keetr.theupdate.network.models.LatestHeadlinesApiModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

const val TAG = "NewsDatasource"

internal class NewsCatcherDatasource(private val client: HttpClient) : NewsDatasource {
    override suspend fun fetchLatestHeadlines(
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
        page: Int
    ): Response<LatestHeadlinesApiModel> {
        val response = client.get("/v2/latest_headlines") {
            if (duration.isNotBlank()) parameter("when", duration)
            if (lang.isNotEmpty()) parameter("lang", lang)
            if (notLang.isNotEmpty()) parameter("not_lang", notLang)
            if (countries.isNotEmpty()) parameter("countries", countries)
            if (notCountries.isNotEmpty()) parameter("not_countries", notCountries)
            if (topic.isNotBlank()) parameter("topic", topic)
            if (sources.isNotEmpty()) parameter("sources", sources)
            if (notSources.isNotEmpty()) parameter("not_sources", notSources)
            parameter("ranked_only", rankedOnly)
            parameter("page_size", pageSize)
            parameter("page", page)
        }
        return when (response.status.value) {
            200 -> {
                Log.i(TAG, "fetchLatestHeadlines: ${response.status}")
                val data: LatestHeadlinesApiModel = response.body()
                Log.i(TAG, "fetchLatestHeadlines: Got data for query ${data.userInput}")
                Success(data)
            }

            else -> {
                Log.e(TAG, "fetchLatestHeadlines: ${response.status}")
                Log.e(TAG, "fetchLatestHeadlines: ${response.body<ErrorApiModel>()}")
                val error: ErrorApiModel = response.body()
                Error(error)
            }
        }
    }

}