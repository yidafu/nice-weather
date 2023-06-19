package dev.yidafu.app.weather.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yidafu.app.weather.Greeting
import dev.yidafu.app.weather.android.activity.place.PlaceActivity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    LaunchedEffect(true) {
                        val data = Greeting().greet()
                        Log.i("Main", Json.encodeToString(data))
                    }
                    GreetingView("XXX")

                    Button(
                        modifier = Modifier.width(80.dp).height(40.dp),
                        onClick = {
                            startActivity(Intent(this.applicationContext, PlaceActivity::class.java))
                        },
                    ) {
                        Text(text = "Place Page")
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
