package dev.yidafu.app.weather

import dev.yidafu.app.weather.network.WeatherApi

class Greeting {
    private val platform: Platform = getPlatform()

    suspend fun greet(): String {
        return WeatherApi().getCityData("杭州")
    }
}
