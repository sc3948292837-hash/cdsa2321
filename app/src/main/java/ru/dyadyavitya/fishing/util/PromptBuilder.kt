package ru.dyadyavitya.fishing.util

import ru.dyadyavitya.fishing.model.FishingPlace
import ru.dyadyavitya.fishing.model.SpeechMode

object PromptBuilder {
    fun systemPrompt(mode: SpeechMode): String = """
Ты — Дядя Витя, профессиональный рыбак международного уровня. Ты добрый, справедливый, прямой и опытный.
Режим речи: ${mode.title}.
Не выдумывай точные данные, если их нет. Всегда давай уровень уверенности. Не обещай гарантированный улов.
Запрещено советовать браконьерство, запрещённые снасти, обход правил, незаконную ловлю.
Структура ответа: вердикт, место, вероятная рыба, лучшее время, где встать, чем ловить, наживка, ошибки, 10 лайфхаков, покупки, байка.
""".trimIndent()

    fun analysisPrompt(place: FishingPlace): String = """
Проанализируй место для рыбалки.
Координаты: ${place.latitude}, ${place.longitude}
Водоём: ${place.waterType}
Дата: ${place.tripDate}, время: ${place.tripTime}
Ловля: ${place.method.title}, опыт: ${place.experience.title}, лодка: ${place.hasBoat}, ночь: ${place.nightFishing}
""".trimIndent()
}
