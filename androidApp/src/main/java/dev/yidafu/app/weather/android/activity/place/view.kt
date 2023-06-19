package dev.yidafu.app.weather.android.activity.place

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.yidafu.app.weather.android.R
import dev.yidafu.app.weather.android.activity.place.ui.theme.NiceWeatherTheme
import dev.yidafu.app.weather.android.common.painterResourceCompat

@Composable
fun PlaceView(name: String, modifier: Modifier = Modifier) {
    val placeVm: PlaceViewModel = viewModel()

    val placeList = placeVm.placeLiveData.observeAsState()
    var query by remember {
        mutableStateOf("")
    }

    ConstraintLayout(Modifier.fillMaxSize().background(Color.White).border(2.dp, Color.Red)) {
        val box = createRef()
        Box(
            modifier = Modifier.constrainAs(box) { top.linkTo(parent.top, 0.dp) }
                .height(60.dp).fillMaxWidth().background(MaterialTheme.colors.primary),
        ) {
            OutlinedTextField(
                value = query,
                modifier = Modifier
                    .fillMaxWidth().height(60.dp).background(Color.White).padding(5.dp)
                    .paint(painterResourceCompat(R.drawable.search_bg)),
                onValueChange = {
                    query = it
                    Log.i("PlaceView", "Text Value Change $it")
                    placeVm.searchPlace(it)
                },
            )
        }

        val image = createRef()
        Image(
            painter = painterResource(R.drawable.bg_place),
            contentDescription = "Place Input Place",
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxWidth()
                .constrainAs(image) { bottom.linkTo(parent.bottom) },
        )

        val lazyCol = createRef()
        if (placeList.value?.isNotEmpty() == true) {
            LazyColumn(
                Modifier.fillMaxWidth().constrainAs(lazyCol) { top.linkTo(box.bottom) },
            ) {
                items(items = placeList.value!!, key = { it.id }) { place ->
                    Card(
                        modifier.fillMaxWidth().padding(12.dp),
                        elevation = 10.dp,
                    ) {
                        Column(
                            Modifier.fillMaxWidth().padding(18.dp),
                        ) {
                            Text(text = place.name, fontSize = 20.sp, color = MaterialTheme.colors.onSecondary)
                            Text(text = place.address, fontSize = 14.sp, color = MaterialTheme.colors.onSurface)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NiceWeatherTheme {
        PlaceView("Android")
    }
}
