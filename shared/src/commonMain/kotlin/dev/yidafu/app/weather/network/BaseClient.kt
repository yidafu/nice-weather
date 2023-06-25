package dev.yidafu.app.weather.network

import dev.yidafu.app.weather.ktorLog
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.resources.Resources
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

open class BaseClient {
    protected val client = HttpClient() {
        defaultRequest {
            url("https://api.caiyunapp.com")
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
        install(Resources)
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    ktorLog(message)
                }
            }
            level = LogLevel.HEADERS
        }
        install(ContentNegotiation) {
            json(
                Json {
//                    encodeDefaults = true
                    prettyPrint = true
//                    isLenient = true
                    ignoreUnknownKeys = true
                },
            )
        }
    }
}
