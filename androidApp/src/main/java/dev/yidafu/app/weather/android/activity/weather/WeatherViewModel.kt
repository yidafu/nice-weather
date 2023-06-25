package dev.yidafu.app.weather.android.activity.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import dev.yidafu.app.weather.android.Repository
import dev.yidafu.app.weather.bean.response.Location

class WeatherViewModel : ViewModel() {
    private val locationLv = MutableLiveData<Location>()

    val weatherLv = locationLv.switchMap { location ->
        Repository.refreshWeather(location)
    }

    fun refreshWeather(location: Location) {
        locationLv.value = location
    }

    fun refreshWeather(lng: Double, lat: Double) {
        refreshWeather(Location(lng, lat))
    }
}
