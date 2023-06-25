package dev.yidafu.app.weather.android

import android.util.Log
import androidx.lifecycle.liveData
import dev.yidafu.app.weather.bean.response.Location
import dev.yidafu.app.weather.bean.vo.WeatherVO
import dev.yidafu.app.weather.network.WeatherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

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

    fun realtimeWeather(location: Location) = liveData(Dispatchers.IO) {
        val realtime = WeatherApi.realtime(location).result.realtime
        emit(realtime)
    }

    fun dailyWeather(location: Location) = liveData(Dispatchers.IO) {
        val daily = WeatherApi.daily(location)
        emit(daily)
    }

    fun refreshWeather(location: Location) = liveData(Dispatchers.IO) {
        coroutineScope {
            val deferredRealtime = async {
                WeatherApi.realtime(location)
            }
            val deferredDaily = async {
                WeatherApi.daily(location)
            }

            val realtimeResponse = deferredRealtime.await()
            val dailyResponse = deferredDaily.await()

            emit(WeatherVO(realtimeResponse.result.realtime, dailyResponse.result.daily))
//            if (realtimeResponse.status == "ok" && dailyResponse.status == "ok") {
//
//                Result.success(WeatherVO(realtimeResponse.result.realtime, dailyResponse.result.daily))
//            } else {
//                Result.failure(RuntimeException("status => ${realtimeResponse.status}, status => ${dailyResponse.status}"))
//            }
        }
    }
}
