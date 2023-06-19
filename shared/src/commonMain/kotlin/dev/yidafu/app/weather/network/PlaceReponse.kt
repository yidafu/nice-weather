package dev.yidafu.app.weather.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlaceResponse(
    val status: String,
    val query: String,
    val places: List<Place>,
//    val place_id: String,
) {

    @Serializable
    data class Location(
        val lat: String,
        val lng: String,
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
}
