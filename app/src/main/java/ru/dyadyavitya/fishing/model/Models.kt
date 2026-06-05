package ru.dyadyavitya.fishing.model

enum class FishingMethod(val title: String) { SPINNING("Спиннинг"), FEEDER("Фидер"), FLOAT("Поплавок"), DONKA("Донка"), FLY("Нахлыст"), WINTER("Зимняя") }
enum class Experience(val title: String) { BEGINNER("Новичок"), MIDDLE("Средний"), PRO("Опытный") }
enum class SpeechMode(val title: String) { CLEAN("Цензурный"), ADULT("Дядя Витя 18+") }

data class FishingPlace(
    val id: String,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val waterType: String,
    val tripDate: String,
    val tripTime: String,
    val method: FishingMethod,
    val experience: Experience,
    val hasBoat: Boolean,
    val nightFishing: Boolean,
    val isFavorite: Boolean = false
)

data class WeatherReport(
    val temperatureC: Int,
    val windMs: Double,
    val windDirection: String,
    val pressureMm: Int,
    val pressureTrend: String,
    val clouds: Int,
    val precipitation: String,
    val humidity: Int,
    val warning: String? = null
)

data class FishSpecies(
    val name: String,
    val icon: String,
    val probability: Int,
    val whereToFind: String,
    val bait: String,
    val tactic: String
)

data class TackleRecommendation(val title: String, val details: String, val priority: String)
data class ShoppingItem(val title: String, val category: String, var checked: Boolean = false, val priority: String)

data class FishingAnalysis(
    val verdict: String,
    val biteScore: Int,
    val confidence: Int,
    val bestTime: String,
    val risks: List<String>,
    val weather: WeatherReport,
    val fish: List<FishSpecies>,
    val tackle: List<TackleRecommendation>,
    val lifehacks: List<String>,
    val shopping: List<ShoppingItem>,
    val vityaPhrase: String,
    val safety: String = "Прогноз клёва не является гарантией улова. Соблюдайте правила рыболовства, сезонные ограничения, нормы вылова и требования безопасности на воде."
)
