package com.keetr.theupdate.network

import android.util.Log
import com.keetr.theupdate.network.fake.LatestHeadlinesResponse
import com.keetr.theupdate.network.fake.TimeoutResponse
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.mockk.every
import io.mockk.mockkStatic
import kotlinx.coroutines.test.runTest

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DefaultNewsDatasourceTest {
//    private lateinit var client: HttpClient
//    private lateinit var datasource: NewsDatasource

    @Before
    fun setUp() {
        mockkStatic(Log::class)
        every { Log.v(any(), any()) } returns 0
        every { Log.d(any(), any()) } returns 0
        every { Log.i(any(), any()) } returns 0
        every { Log.e(any(), any()) } returns 0
    }

    @Test
    fun latestHeadlinesSuccessTest() = runTest {

        val mockEngine = MockEngine {
            respond(
                headers = headersOf(HttpHeaders.ContentType, "application/json"),
                status = HttpStatusCode.OK,
                content =  LatestHeadlinesResponse
            )
        }

        val datasource = DefaultNewsDatasource(createClient(mockEngine))

        val res = datasource.fetchLatestHeadlines(
            duration = "",
            lang = listOf(),
            notLang = listOf(),
            countries = listOf(),
            notCountries = listOf(),
            topic = "",
            sources = listOf(),
            notSources = listOf(),
            rankedOnly = false,
            pageSize = 0,
            page = 0

        )
        if(res is Success) {
            with(res.data) {
                assertEquals(articles.size, 30)
                assertEquals(pageSize, 30)
                assertEquals(articles.first().author, "Harrow Times Staff")
            }
        }
    }

    fun timeoutTest() = runTest {

        val mockEngine = MockEngine {
            respond(
                headers = headersOf(HttpHeaders.ContentType, "application/json"),
                status = HttpStatusCode.RequestTimeout,
                content =  TimeoutResponse
            )
        }

        val datasource = DefaultNewsDatasource(createClient(mockEngine))

        val res = datasource.fetchLatestHeadlines(
            duration = "",
            lang = listOf(),
            notLang = listOf(),
            countries = listOf(),
            notCountries = listOf(),
            topic = "",
            sources = listOf(),
            notSources = listOf(),
            rankedOnly = false,
            pageSize = 0,
            page = 0

        )
        if(res is Error) {
            with(res.error) {
                assertEquals(errorCode, "UnsupportedParameter")
                assertEquals(message, "Request takes more than 30 seconds. Your search is too broad.Try to use more parameters to narrow down the request.")
            }
        }
    }
}