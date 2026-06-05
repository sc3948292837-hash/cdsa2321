package ru.dyadyavitya.fishing.services

import kotlinx.coroutines.delay
import ru.dyadyavitya.fishing.model.*

interface AIServiceProtocol {
    suspend fun analyze(place: FishingPlace, speechMode: SpeechMode): FishingAnalysis
    suspend fun askVitya(question: String, speechMode: SpeechMode): String
}

class MockAIService : AIServiceProtocol {
    override suspend fun analyze(place: FishingPlace, speechMode: SpeechMode): FishingAnalysis {
        delay(500)
        val rough = speechMode == SpeechMode.ADULT
        val phrase = if (rough) "Ну место бодрое, рыбачок. Не халява, но шанс есть — без дурной суеты и с головой." else "Место интересное. Не сказка, но шанс хороший, если аккуратно прочитать воду."
        return FishingAnalysis(
            verdict = "Можно ехать: лучшее окно утром и перед закатом",
            biteScore = 74,
            confidence = 68,
            bestTime = "05:20–08:40 и 18:30–21:10",
            risks = listOf("Ветер может прижать волну к открытому берегу", "При скачке давления хищник станет пассивнее", "Без координат глубины определены приблизительно"),
            weather = WeatherReport(18, 4.6, "северо-запад", 748, "медленно растёт", 62, "без сильных осадков", 71),
            fish = listOf(
                FishSpecies("Щука", "🐊", 76, "Граница травы и глубины, входы в заливы", "воблер 90–110 мм, силикон 3–4 дюйма", "медленная проводка с паузами"),
                FishSpecies("Окунь", "🐟", 82, "Мелководные косы, камни, коряжник", "вертушка №2, микроджиг", "ступенька и короткие рывки"),
                FishSpecies("Лещ", "🐠", 58, "Бровка и спокойная вода за поворотом", "мотыль, опарыш, пшено", "точечный закорм без перекорма"),
                FishSpecies("Карась", "🎣", 63, "Тёплые окна среди травы", "червь, кукуруза, тесто", "тихая подача и тонкий поводок")
            ),
            tackle = listOf(
                TackleRecommendation("Спиннинг", "2.1–2.4 м, тест 5–25 г, плетня PE 0.8–1.0", "обязательно"),
                TackleRecommendation("Фидер", "кормушка 40–60 г, поводок 0.12–0.16, крючок №10–14", "желательно"),
                TackleRecommendation("Поводки", "флюорокарбон для окуня, стальной/титановый для щуки", "обязательно")
            ),
            lifehacks = listOf(
                "Не начинай с самой глубокой точки — сначала проверь вход в яму.",
                "Если ветер дует в берег, рыба часто подходит ближе.",
                "При скачке давления уменьшай приманку и замедляй проводку.",
                "На мутной воде ставь заметнее цвет, на прозрачной — натуральнее.",
                "Утром проверяй мелководье, днём — бровки.",
                "Если 20 минут тишина — меняй горизонт или точку.",
                "Леща не перекармливай сразу: лучше часто и малыми порциями.",
                "Для карася сладкая ароматика работает, но без фанатизма.",
                "На щуку ставь поводок: она не спрашивает разрешения откусить.",
                "Всегда держи запасной план по рыбе и берегу."
            ),
            shopping = listOf(
                ShoppingItem("Воблер 90–110 мм", "Снасти", false, "обязательно"),
                ShoppingItem("Силикон 3–4 дюйма", "Снасти", false, "обязательно"),
                ShoppingItem("Опарыш / червь", "Наживка", false, "желательно"),
                ShoppingItem("Панировочные сухари + пшено", "Прикормка", false, "желательно"),
                ShoppingItem("Фонарь, аптечка, вода", "Безопасность", false, "обязательно"),
                ShoppingItem("Документы и разрешения", "Документы", false, "обязательно")
            ),
            vityaPhrase = phrase
        )
    }

    override suspend fun askVitya(question: String, speechMode: SpeechMode): String {
        delay(300)
        return if (speechMode == SpeechMode.ADULT) "Смотри, без геройства: $question — разбирай по месту, ветру и глубине. Рыба любит умных, а не шумных." else "Разберём спокойно: $question. Сначала смотри ветер, глубину, кормовую базу и активность рыбы."
    }
}

class RealAIService(private val apiKey: String?) : AIServiceProtocol {
    override suspend fun analyze(place: FishingPlace, speechMode: SpeechMode): FishingAnalysis {
        if (apiKey.isNullOrBlank()) return MockAIService().analyze(place, speechMode)
        // TODO: подключить свой AI API через OkHttp/Retrofit или URLConnection.
        return MockAIService().analyze(place, speechMode)
    }
    override suspend fun askVitya(question: String, speechMode: SpeechMode): String = MockAIService().askVitya(question, speechMode)
}
