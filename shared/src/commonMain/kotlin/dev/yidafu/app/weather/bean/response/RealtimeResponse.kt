package dev.yidafu.app.weather.bean.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RealtimeResponse(
    val status: String,
    @SerialName("api_version")
    val apiVersion: String,
    @SerialName("api_status")
    val apiStatus: String,
    val lang: String,
    val unit: String,
    val tzshift: Int,
    val timezone: String,
    @SerialName("server_time")
    val serverTime: Long,
    val location: List<Double>,
    val result: Result,
) {

    @Serializable
    data class Result(val realtime: RealTime)

    @Serializable
    data class RealTime(
        val status: String,
        val temperature: Float,
        @SerialName("apparent_temperature")
        val apparentTemperature: Float,
        val pressure: Float,
        val humidity: Float,
        val dswrf: Float,
        val wind: Wind,
        val precipitation: Precipitation,
        val cloudrate: Float,
        val visibility: Float,
        val skycon: String,
        @SerialName("air_quality")
        val airQuality: AirQuality,
    )

    @Serializable
    data class Wind(
        val speed: Float,
        val direction: Float,
    )

    @Serializable
    data class Precipitation(
        val local: PrecipitationLocalData,
        val nearest: PrecipitationData,
    )

    @Serializable
    data class PrecipitationData(
        val distance: Float,
        val intensity: Float,
    )

    @Serializable
    data class PrecipitationLocalData(
        val datasource: String,
        val intensity: Float,
    )

    @Serializable
    data class AirQuality(
        val pm25: Float,
        val pm10: Float,
        val o3: Float,
        val no2: Float,
        val so2: Float,
        val co: Float,
        val aqi: Api,
        val description: AirQualityDescription,
    )

    @Serializable
    data class Api(
        val chn: Float,
        val usa: Float,
    )

    @Serializable
    data class AirQualityDescription(
        val chn: String,
        val usa: String,
    )
}
