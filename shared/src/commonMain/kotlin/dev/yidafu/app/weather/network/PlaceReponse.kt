package dev.yidafu.app.weather.network

import kotlinx.serialization.Serializable


@Serializable
data class Location(
    val lat: String,
    val lng: String,
)

@Serializable
data class Place(
    val id: String,
    val name: String,
    val formatted_address: String,
    val location: Location,
    val place_id: String,
)

@Serializable
data class PlaceResponse(
    val status: String,
    val query: String,
    val places: List<Place>,
    val place_id: String,
)
