package dev.yidafu.app.weather.android.activity.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import dev.yidafu.app.weather.android.Repository
import dev.yidafu.app.weather.bean.response.Location
import dev.yidafu.app.weather.bean.vo.WeatherVO

class WeatherViewModel : ViewModel() {
    private val locationLv = MutableLiveData(Location(lat = 30.222719, lng = 120.121282))

    val weatherLv: LiveData<WeatherVO> = locationLv.switchMap { location ->
        Repository.refreshWeather(location)
    }

    fun refreshWeather(location: Location) {
        locationLv.value = location
    }

    fun refreshWeather(lng: Double, lat: Double) {
        refreshWeather(Location(lng, lat))
    }
}
