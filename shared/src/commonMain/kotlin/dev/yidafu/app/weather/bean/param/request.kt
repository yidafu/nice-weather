package dev.yidafu.app.weather.bean.param

import dev.yidafu.app.weather.constants.WEATHER_TOKEN
import dev.yidafu.app.weather.network.Location
import io.ktor.resources.Resource

@Resource("/v2.6")
class V2dot6() {

    @Resource("{token}")
    data class Token(val token: String = WEATHER_TOKEN, val parent: V2dot6 = V2dot6()) {

        @Resource("{location}")
        data class ApiLocation(
            val lot: Location,
            val location: String = "${lot.lng},${lot.lat}",
            val parent: Token = Token(),
        ) {
            @Resource("realtime")
            class RealTime(private val location: Location, val parent: ApiLocation = ApiLocation(location))
        }
    }
}

typealias RealTimeRequest = V2dot6.Token.ApiLocation.RealTime

@Resource("/v2")
class V2() {
    @Resource("place")
    class Place(
        val query: String,
        val lang: String = "zh_CN",
        val token: String = WEATHER_TOKEN,
        val parent: V2 = V2(),
    )
}

typealias PlaceRequest = V2.Place
