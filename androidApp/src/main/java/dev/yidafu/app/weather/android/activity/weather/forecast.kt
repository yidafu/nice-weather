package dev.yidafu.app.weather.android.activity.place

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.yidafu.app.weather.android.activity.weather.WeatherViewModel
import dev.yidafu.app.weather.android.activity.weather.getSky
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun Forecast() {
    val weatherVM: WeatherViewModel = viewModel()
    val weatherState = weatherVM.weatherLv.observeAsState()
    val skyconList = weatherState.value?.daily?.skycon ?: emptyList()
    val temperatureList = weatherVM.weatherLv.value?.daily?.temperature ?: emptyList()
    val list = skyconList.mapIndexed {
            index, skycon ->
        Log.i("TT", Json.encodeToString(skycon))
        Pair(skycon, temperatureList[index])
    }

    Card(
        modifier = Modifier.fillMaxWidth().padding(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp,
        ),
    ) {
        Column(Modifier.padding(horizontal = 20.dp, vertical = 15.dp)) {
            Text("预报", fontSize = 20.sp, color = Color(0xFF555555))
            Column {
                list.forEach {
                    Row(
                        Modifier.fillMaxWidth().padding(top = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(it.first.date.slice(0..9))
                        Image(painter = painterResource(getSky(it.first.value).icon), contentDescription = "Icon")
                        Text("${it.second.min} ~ ${it.second.max} ℃")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForecastPreview() {
    Forecast()
}
