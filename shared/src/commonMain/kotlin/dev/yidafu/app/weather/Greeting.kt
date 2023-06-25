package dev.yidafu.app.weather

import dev.yidafu.app.weather.bean.response.PlaceResponse
import dev.yidafu.app.weather.network.WeatherApi

class Greeting {
    private val platform: Platform = getPlatform()

    suspend fun greet(): PlaceResponse {
        return WeatherApi.getCityData("杭州")
    }
}
