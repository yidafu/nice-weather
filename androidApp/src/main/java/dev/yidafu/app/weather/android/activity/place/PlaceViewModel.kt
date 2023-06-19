package dev.yidafu.app.weather.android.activity.place

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import dev.yidafu.app.weather.android.Repository
import dev.yidafu.app.weather.network.PlaceResponse

class PlaceViewModel : ViewModel() {
    val searchQuery = MutableLiveData<String>()

    val placeList = listOf<PlaceResponse.Place>()

    val placeLiveData = searchQuery.switchMap { query ->
        Repository.searchPlace(query)
    }

    fun searchPlace(query: String) {
        Log.i(TAG, "search place $query")
        searchQuery.value = query
    }

    companion object {
        const val TAG = "PlaceViewModel"
    }
}
