package dev.yidafu.app.weather.android.activity.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import dev.yidafu.app.weather.android.R

@Composable
fun LifeIndex() {
    val weatherVM: WeatherViewModel = viewModel()
    val weatherState = weatherVM.weatherLv.observeAsState()
    val lifeIndex = weatherState.value?.daily?.lifeIndex
    Card(
        modifier = Modifier.fillMaxWidth().padding(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
    ) {
        Column(Modifier.padding(horizontal = 20.dp, vertical = 15.dp)) {
            Text("生活指数", fontSize = 20.sp, color = Color(0xff555555))

            Row(modifier = Modifier.fillMaxWidth().padding(top = 20.dp), horizontalArrangement = Arrangement.SpaceAround) {
                LifeIndexBlock(lifeIndex?.coldRisk?.get(0)?.desc ?: "", "感冒", R.drawable.ic_coldrisk)
                LifeIndexBlock(lifeIndex?.dressing?.get(0)?.desc ?: "", "穿衣", R.drawable.ic_dressing)
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                LifeIndexBlock(lifeIndex?.ultraviolet?.get(0)?.desc ?: "", "实时紫外线", R.drawable.ic_ultraviolet)
                LifeIndexBlock(lifeIndex?.carWashing?.get(0)?.desc ?: "", "洗车", R.drawable.ic_carwashing)
            }
        }
    }
}

@Composable
fun LifeIndexBlock(text: String = "", type: String, image: Int) {
    Row(Modifier.height(60.dp).width(130.dp)) {
        Image(painter = painterResource(id = image), contentDescription = "icon")
        Column(Modifier.padding(start = 20.dp)) {
            Text(type, fontSize = 12.sp)
            Text(text, modifier = Modifier.padding(top = 4.dp), fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LifeIndexPreview() {
    LifeIndex()
}
