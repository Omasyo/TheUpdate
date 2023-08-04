package com.keetr.theupdate.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.basic
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.URLProtocol
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import java.io.File

val Client by lazy {
    HttpClient(CIO) {
//    install(Auth) {
//    }
        headers {
            append("x-api-key", ApiKey)
        }
        install(ContentNegotiation) {
            json(Json {
//            ignoreUnknownKeys = true
//            coerceInputValues = true
            })
            install(HttpCache) {
//            val cacheFile = File(context.cacheDir, "ClientCache")
//            publicStorage(FileStorage(cacheFile))
            }
        }
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "api.newscatcherapi.com"
            }
        }
    }
}