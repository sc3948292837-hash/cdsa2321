package ru.dyadyavitya.fishing.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DeepWater = Color(0xFF0B1F2A)
val Graphite = Color(0xFF18242E)
val Swamp = Color(0xFF2F5D50)
val Gold = Color(0xFFD7A84D)
val Mist = Color(0xFFF1F5F4)

private val DarkColors = darkColorScheme(primary = Gold, secondary = Swamp, background = DeepWater, surface = Graphite, onPrimary = DeepWater, onBackground = Mist, onSurface = Mist)
private val LightColors = lightColorScheme(primary = Swamp, secondary = Gold, background = Mist, surface = Color.White, onPrimary = Color.White, onBackground = DeepWater, onSurface = DeepWater)

@Composable
fun DyadyaVityaTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = if (darkTheme) DarkColors else LightColors, typography = Typography(), content = content)
}
