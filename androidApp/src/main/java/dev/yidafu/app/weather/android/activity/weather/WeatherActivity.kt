package dev.yidafu.app.weather.android.activity.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.yidafu.app.weather.android.activity.place.Forecast
import dev.yidafu.app.weather.android.theme.NiceWeatherTheme

class WeatherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NiceWeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Weather()
                }
            }
        }
    }
}

@Composable
fun Weather() {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        Now()
        Forecast()
        LifeIndex()
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherPreview() {
    NiceWeatherTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Weather()
        }
    }
}
