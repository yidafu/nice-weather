package dev.yidafu.app.weather

import android.util.Log

actual fun ktorLog(msg: String) {
    Log.i("KtorLogging", msg)
}