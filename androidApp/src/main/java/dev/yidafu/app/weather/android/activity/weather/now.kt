package dev.yidafu.app.weather.android.activity.weather

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.yidafu.app.weather.android.R
import dev.yidafu.app.weather.bean.vo.SkyVO

val skyMap = mapOf(
    "CLEAR_DAY" to SkyVO("晴", R.drawable.ic_clear_day, R.drawable.bg_clear_day),
    "CLEAR_NIGHT" to SkyVO("晴", R.drawable.ic_clear_night, R.drawable.bg_clear_night),
    "PARTLY_CLOUDY_DAY" to SkyVO("多云", R.drawable.ic_partly_cloud_day, R.drawable.bg_partly_cloudy_day),
    "PARTLY_CLOUDY_NIGHT" to SkyVO("多云", R.drawable.ic_partly_cloud_night, R.drawable.bg_partly_cloudy_night),
    "CLOUDY" to SkyVO("阴", R.drawable.ic_cloudy, R.drawable.bg_cloudy),
    "LIGHT_HAZE" to SkyVO("轻度雾霾", R.drawable.ic_light_rain, R.drawable.bg_fog),
    "MODERATE_HAZE" to SkyVO("中度雾霾", R.drawable.ic_moderate_haze, R.drawable.bg_fog),
    "HEAVY_HAZE" to SkyVO("重度雾霾", R.drawable.ic_heavy_haze, R.drawable.bg_fog),

    "LIGHT_RAIN" to SkyVO("小雨", R.drawable.ic_light_rain, R.drawable.bg_rain),
    "MODERATE_RAIN" to SkyVO("中雨", R.drawable.ic_moderate_rain, R.drawable.bg_rain),
    "HEAVY_RAIN" to SkyVO("大雨", R.drawable.ic_heavy_rain, R.drawable.bg_rain),
    "STORM_RAIN" to SkyVO("暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain),

    "FOG" to SkyVO("雾", R.drawable.ic_fog, R.drawable.bg_fog),

    "LIGHT_SNOW" to SkyVO("小雪", R.drawable.ic_light_snow, R.drawable.bg_snow),
    "MODERATE_SNOW" to SkyVO("中雪", R.drawable.ic_moderate_snow, R.drawable.bg_snow),
    "HEAVY_SNOW" to SkyVO("大雪", R.drawable.ic_heavy_snow, R.drawable.bg_snow),
//            "SAND" to SkyVO("沙尘", R.drawable.ic_fog, R.drawable.bg_fog),
    "Wind" to SkyVO("大风", R.drawable.ic_cloudy, R.drawable.bg_cloudy),
//            "DUST"
)

fun getSky(type: String?): SkyVO {
    return skyMap[type ?: "CLEAR_DAY"]!!
}

@Composable
fun Now() {
    val type = "CLEAR_DAY"
    val viewModel: WeatherViewModel = viewModel()
    val placeNameState = viewModel.placeName.observeAsState()
    val weatherState = viewModel.weatherLv.observeAsState()
    Column(
        modifier = Modifier
            .paint(painterResource(id = getSky(type).bg), contentScale = ContentScale.FillWidth)
            .fillMaxWidth()
            .height(530.dp),
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(top = 70.dp),
        ) {
            Text(
                text = placeNameState.value ?: "",
                modifier = Modifier
                    .padding(horizontal = 60.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 22.sp,
            )
        }

        Column(Modifier.padding(60.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "${weatherState.value?.realtime?.temperature ?: 0} ℃", color = Color.White, fontSize = 70.sp)
            Row {
                Text(getSky(weatherState.value?.realtime?.skycon).info, color = Color.White, fontSize = 18.sp)
                Text("|", color = Color.White, fontSize = 18.sp, modifier = Modifier.padding(horizontal = 13.dp))
                Text("空气指数 ${weatherState.value?.realtime?.airQuality?.aqi?.chn ?: 0}", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NowPreview() {
    Now()
}
