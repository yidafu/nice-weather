package dev.yidafu.app.weather.android

import android.util.Log
import androidx.lifecycle.liveData
import dev.yidafu.app.weather.network.WeatherApi
import kotlinx.coroutines.Dispatchers

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
}