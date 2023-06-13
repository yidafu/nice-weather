package dev.yidafu.app.weather.network

import dev.yidafu.app.weather.constants.WEATHER_TOKEN
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText

class WeatherApi : BaseClient() {
    suspend fun getCityData(city: String, lang: String = "zh_CN"): String {
        return client.get("/v2/place") {
            parameter("query", city)
            parameter("token", WEATHER_TOKEN)
            parameter("lang", lang)
        }.bodyAsText()
    }
}
