package dev.yidafu.app.weather.android

import android.util.Log
import androidx.lifecycle.liveData
import dev.yidafu.app.weather.network.Location
import dev.yidafu.app.weather.network.WeatherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object Repository {
    const val TAG = "Repository"
    fun searchPlace(query: String) = liveData(Dispatchers.IO) {
        val data = try {
            WeatherApi.getCityData(query).places
        } catch (err: Exception) {
            Log.e(TAG, err.stackTraceToString())
            emptyList()
        }
        emit(data)
    }

    fun realtime(location: Location) = liveData(Dispatchers.IO) {
        val realtime = WeatherApi.realtime(location).result.realtime
        emit(realtime)
    }
}