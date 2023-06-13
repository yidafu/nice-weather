package dev.yidafu.app.weather.network

import kotlinx.serialization.Serializable

@Serializable
data class Response<T> (
    val status: String,
    val query: String,
)