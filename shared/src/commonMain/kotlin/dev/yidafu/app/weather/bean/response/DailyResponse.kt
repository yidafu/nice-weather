package dev.yidafu.app.weather.bean.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyResponse(
    @SerialName("api_status")
    val api_status: String,
    @SerialName("api_version")
    val api_version: String,
    val lang: String,
    val location: List<Double>,
    val result: Result,
    @SerialName("server_time")
    val serverTime: Int,
    val status: String,
    val timezone: String,
    val tzshift: Int,
    val unit: String,
) {
    @Serializable
    data class Result(
        val daily: Daily,
        val primary: Int,
    )

    @Serializable
    data class Daily(
        @SerialName("air_quality")
        val airQuality: AirQuality,
        val astro: List<Astro>,
        val cloudrate: List<Cloudrate>,
        val dswrf: List<Dswrf>,
        val humidity: List<Humidity>,
        @SerialName("life_index")
        val lifeIndex: LifeIndex,
        val precipitation: List<Precipitation>,
        @SerialName("precipitation_08h_20h")
        val precipitation08h20h: List<Precipitation>,
        @SerialName("precipitation_20h_32h")
        val precipitation20h32h: List<Precipitation>,
        val pressure: List<Pressure>,
        val skycon: List<Skycon>,
        @SerialName("skycon_08h_20h")
        val skycon08h20h: List<Skycon>,
        @SerialName("skycon_20h_32h")
        val skycon20h32h: List<Skycon>,
        val status: String,
        val temperature: List<Temperature>,
        @SerialName("temperature_08h_20h")
        val temperature08h20h: List<Temperature>,
        @SerialName("temperature_20h_32h")
        val temperature20h32h: List<Temperature>,
        val visibility: List<Visibility>,
        val wind: List<Wind>,
        @SerialName("wind_08h_20h")
        val wind_08h_20h: List<Wind>,
        @SerialName("wind_20h_32h")
        val wind_20h_32h: List<Wind>,
    )

    @Serializable
    data class AirQuality(
        val aqi: List<Aqi>,
        val pm25: List<Pm25>,
    )

    @Serializable
    data class Astro(
        val date: String,
        val sunrise: Sunrise,
        val sunset: Sunset,
    )

    @Serializable
    data class Cloudrate(
        val avg: Float,
        val date: String,
        val max: Float,
        val min: Float,
    )

    @Serializable
    data class Dswrf(
        val avg: Double,
        val date: String,
        val max: Float,
        val min: Float,
    )

    @Serializable
    data class Humidity(
        val avg: Double,
        val date: String,
        val max: Double,
        val min: Double,
    )

    @Serializable
    data class LifeIndex(
        val carWashing: List<CarWashing>,
        val coldRisk: List<ColdRisk>,
        val comfort: List<Comfort>,
        val dressing: List<Dressing>,
        val ultraviolet: List<Ultraviolet>,
    )

    @Serializable
    data class Precipitation(
        val avg: Float,
        val date: String,
        val max: Float,
        val min: Float,
        val probability: Float,
    )

    @Serializable
    data class Pressure(
        val avg: Double,
        val date: String,
        val max: Double,
        val min: Double,
    )

    @Serializable
    data class Skycon(
        val date: String,
        val value: String,
    )

    @Serializable
    data class Temperature(
        val avg: Double,
        val date: String,
        val max: Float,
        val min: Float,
    )

    @Serializable
    data class Visibility(
        val avg: Float,
        val date: String,
        val max: Float,
        val min: Double,
    )

    @Serializable
    data class Wind(
        val avg: WindRange,
        val date: String,
        val max: WindRange,
        val min: WindRange,
    )

    @Serializable
    data class Aqi(
        val avg: Range,
        val date: String,
        val max: Range,
        val min: Range,
    )

    @Serializable
    data class Pm25(
        val avg: Float,
        val date: String,
        val max: Float,
        val min: Float,
    )

    @Serializable
    data class Range(
        val chn: Float,
        val usa: Float,
    )

    @Serializable
    data class WindRange(
        val speed: Float,
        val direction: Float,
    )

    @Serializable
    data class Sunrise(
        val time: String,
    )

    @Serializable
    data class Sunset(
        val time: String,
    )

    @Serializable
    data class CarWashing(
        val date: String,
        val desc: String,
        val index: String,
    )

    @Serializable
    data class ColdRisk(
        val date: String,
        val desc: String,
        val index: String,
    )

    @Serializable
    data class Comfort(
        val date: String,
        val desc: String,
        val index: String,
    )

    @Serializable
    data class Dressing(
        val date: String,
        val desc: String,
        val index: String,
    )

    @Serializable
    data class Ultraviolet(
        val date: String,
        val desc: String,
        val index: String,
    )
}
