package ru.dyadyavitya.fishing.services

import kotlinx.coroutines.delay
import ru.dyadyavitya.fishing.model.WeatherReport

interface WeatherServiceProtocol { suspend fun getWeather(lat: Double, lon: Double): WeatherReport }
class MockWeatherService : WeatherServiceProtocol {
    override suspend fun getWeather(lat: Double, lon: Double): WeatherReport { delay(200); return WeatherReport(18, 4.6, "северо-запад", 748, "медленно растёт", 62, "без сильных осадков", 71) }
}
class RealWeatherService(private val apiKey: String?) : WeatherServiceProtocol {
    override suspend fun getWeather(lat: Double, lon: Double): WeatherReport {
        if (apiKey.isNullOrBlank()) return MockWeatherService().getWeather(lat, lon)
        // TODO: подключить Weather API. Пока безопасный fallback.
        return MockWeatherService().getWeather(lat, lon)
    }
}
