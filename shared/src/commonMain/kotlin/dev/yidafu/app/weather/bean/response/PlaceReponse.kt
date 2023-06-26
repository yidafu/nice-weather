package dev.yidafu.app.weather.bean.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val lng: Double,
    val lat: Double,
)

@Serializable
data class Place(
    val id: String,
    val name: String,
    @SerialName("formatted_address")
    val address: String,
    val location: Location,
    val place_id: String,
)

@Serializable
data class PlaceResponse(
    val status: String,
    val query: String,
    val places: List<Place>,
//    val place_id: String,
)
