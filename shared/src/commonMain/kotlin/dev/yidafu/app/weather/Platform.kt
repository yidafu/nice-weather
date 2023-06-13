package dev.yidafu.app.weather

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform