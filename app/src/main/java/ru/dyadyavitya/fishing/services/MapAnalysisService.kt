package ru.dyadyavitya.fishing.services

import ru.dyadyavitya.fishing.model.FishingPlace

class MapAnalysisService {
    fun describe(place: FishingPlace): List<String> = listOf(
        "Проверить входы и выходы из ям рядом с координатами ${"%.4f".format(place.latitude)}, ${"%.4f".format(place.longitude)}",
        "Искать границы травы, коряжник, мыс и обратное течение",
        "Без батиметрии рельеф определён приблизительно — для точности подключите внешний API глубин"
    )
}
