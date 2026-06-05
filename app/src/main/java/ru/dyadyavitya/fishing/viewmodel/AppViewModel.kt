package ru.dyadyavitya.fishing.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.dyadyavitya.fishing.model.*
import ru.dyadyavitya.fishing.services.MockAIService

class AppViewModel : ViewModel() {
    var speechMode by mutableStateOf(SpeechMode.CLEAN)
    var demoMode by mutableStateOf(true)
    var adultWarningAccepted by mutableStateOf(false)
    var currentPlace by mutableStateOf(defaultPlace())
    var analysis by mutableStateOf<FishingAnalysis?>(null)
    var isLoading by mutableStateOf(false)
    var chatMessages by mutableStateOf(listOf("Дядя Витя: Ну что, рыбачок, спрашивай. Только координаты не забудь."))
    private val ai = MockAIService()

    fun analyze() {
        viewModelScope.launch {
            isLoading = true
            analysis = ai.analyze(currentPlace, speechMode)
            isLoading = false
        }
    }

    fun ask(question: String) {
        if (question.isBlank()) return
        viewModelScope.launch {
            chatMessages = chatMessages + "Вы: $question"
            chatMessages = chatMessages + "Дядя Витя печатает..."
            val answer = ai.askVitya(question, speechMode)
            chatMessages = chatMessages.dropLast(1) + "Дядя Витя: $answer"
        }
    }

    fun updatePlace(lat: String, lon: String, water: String, date: String, time: String, method: FishingMethod, exp: Experience, boat: Boolean, night: Boolean) {
        currentPlace = FishingPlace("demo-${System.currentTimeMillis()}", "Новая точка", lat.toDoubleOrNull() ?: 55.7558, lon.toDoubleOrNull() ?: 37.6173, water.ifBlank { "река/водохранилище" }, date.ifBlank { "сегодня" }, time.ifBlank { "утро" }, method, exp, boat, night)
    }

    private fun defaultPlace() = FishingPlace("demo", "Демо-точка", 55.7558, 37.6173, "река", "сегодня", "06:00", FishingMethod.SPINNING, Experience.MIDDLE, false, false)
}
