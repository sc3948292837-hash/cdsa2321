package ru.dyadyavitya.fishing.services

import java.time.LocalDate
import kotlin.math.floor

class MoonPhaseService {
    fun phase(date: LocalDate = LocalDate.now()): String {
        val lp = 2551443.0
        val now = date.toEpochDay() * 86400.0
        val newMoon = 592500.0
        val phase = ((now - newMoon) % lp) / lp
        return when {
            phase < 0.03 || phase > 0.97 -> "новолуние"
            phase < 0.25 -> "растущая луна"
            phase < 0.28 -> "первая четверть"
            phase < 0.50 -> "растущая луна"
            phase < 0.53 -> "полнолуние"
            phase < 0.75 -> "убывающая луна"
            phase < 0.78 -> "последняя четверть"
            else -> "убывающая луна"
        }
    }
}
