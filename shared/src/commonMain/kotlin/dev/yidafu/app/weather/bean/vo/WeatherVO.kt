package dev.yidafu.app.weather.bean.vo

import dev.yidafu.app.weather.bean.response.DailyResponse
import dev.yidafu.app.weather.bean.response.RealtimeResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherVO(
    val realtime: RealtimeResponse.RealTime,
    val daily: DailyResponse.Daily
)