package dev.yidafu.app.weather.network

import dev.yidafu.app.weather.bean.request.DailyRequest
import dev.yidafu.app.weather.bean.request.PlaceRequest
import dev.yidafu.app.weather.bean.request.RealTimeRequest
import dev.yidafu.app.weather.bean.response.DailyResponse
import dev.yidafu.app.weather.bean.response.Location
import dev.yidafu.app.weather.bean.response.PlaceResponse
import dev.yidafu.app.weather.bean.response.RealtimeResponse
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get

object WeatherApi : BaseClient() {
    suspend fun getCityData(city: String, lang: String = "zh_CN"): PlaceResponse {
        return client.get(PlaceRequest(city, lang)).body()
    }

    suspend fun realtime(location: Location): RealtimeResponse {
        return client.get(RealTimeRequest(location)).body()
    }

    suspend fun daily(location: Location): DailyResponse {
        return client.get(DailyRequest(location)).body()
    }
}
