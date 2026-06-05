package ru.dyadyavitya.fishing.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.dyadyavitya.fishing.ui.components.*

@Composable fun StoriesScreen(nav: NavController, pad: PaddingValues) {
    val stories = listOf(
        "Как я сома в Казахстане тянул" to "Сом был такой, что лодка сначала подумала: всё, теперь он капитан.",
        "Почему щука не дура" to "Щука стоит там, где ей удобно жрать, а не где тебе красиво на карте.",
        "Окунь — бандит в полосатой робе" to "Если нашёл стаю, работай быстро: окунь любит движение и наглость.",
        "Бесполезная блесна, которая спасла рыбалку" to "Иногда рыба плюёт на теорию и берёт на то, над чем ты сам смеялся."
    )
    PremiumBackground { LazyColumn(Modifier.padding(pad).padding(18.dp), verticalArrangement=Arrangement.spacedBy(12.dp)) { item { Text("Истории Дяди Вити", style=MaterialTheme.typography.headlineMedium) }; items(stories) { GlassCard(Modifier.fillMaxWidth()) { Text(it.first, fontWeight=FontWeight.Bold); Text(it.second) } } } }
}
