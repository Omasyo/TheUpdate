package com.keetr.theupdate.network

import android.util.Log
import com.keetr.theupdate.network.models.ErrorApiModel
import com.keetr.theupdate.network.models.LatestHeadlinesApiModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

const val TAG = "NewsDatasource"

private class DefaultNewsDatasource(private val client: HttpClient) : NewsDatasource {
    override suspend fun fetchLatestHeadlines(
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
        page: Int
    ): Response<LatestHeadlinesApiModel> {
        val response = client.get("/v2/latest_headlines") {
            parameter("when", duration)
            parameter("lang", lang)
            parameter("not_lang", notLang)
            parameter("countries", countries)
            parameter("not_countries", notCountries)
            parameter("topic", topic)
            parameter("sources", sources)
            parameter("not_sources", notSources)
            parameter("ranked_only", ranked)
            parameter("page_size", pageSize)
            parameter("page", page)
        }
        return when(response.status.value) {
            200 -> {
                Log.i(TAG, "fetchLatestHeadlines: $response")
                val data: LatestHeadlinesApiModel = response.body()
                Log.i(TAG, "fetchLatestHeadlines: Got data for query ${data.userInput}")
                Success(data)
            }

            else -> {
                Log.e(TAG, "fetchLatestHeadlines: $response")
                Log.e(TAG, "fetchLatestHeadlines: $response")
                val error: ErrorApiModel = response.body()
                Error(error)
            }
        }
    }

}