package dev.yidafu.app.weather.android.activity.place

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import dev.yidafu.app.weather.android.Repository
import dev.yidafu.app.weather.bean.response.Location
import dev.yidafu.app.weather.bean.response.Place

class PlaceViewModel : ViewModel() {
    val searchQuery = MutableLiveData<String>()

    val placeList = listOf<Place>()

    val placeLiveData = searchQuery.switchMap { query ->
        Repository.searchPlace(query)
    }

    val realtime = placeLiveData.switchMap { list ->
        Log.i(TAG, "realtime")
        val location = if (list.isNotEmpty()) {
//            Log.i(TAG, Json.encodeToString())
            list[0].location
        } else {
            Location(30.246026, 120.210792)
        }
        Repository.realtimeWeather(location)
    }

    fun searchPlace(query: String) {
        Log.i(TAG, "search place $query")
        searchQuery.value = query
    }

    companion object {
        const val TAG = "PlaceViewModel"
    }
}
