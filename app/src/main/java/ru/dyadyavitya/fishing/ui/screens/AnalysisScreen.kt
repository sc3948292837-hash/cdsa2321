package ru.dyadyavitya.fishing.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.dyadyavitya.fishing.ui.components.*
import ru.dyadyavitya.fishing.viewmodel.AppViewModel

@Composable fun AnalysisScreen(nav: NavController, vm: AppViewModel, pad: PaddingValues) {
    val a = vm.analysis
    PremiumBackground { LazyColumn(Modifier.padding(pad).padding(18.dp), verticalArrangement=Arrangement.spacedBy(14.dp)) {
        item { Row(Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.SpaceBetween) { Text("Анализ места", style=MaterialTheme.typography.headlineMedium); TextButton({nav.navigate("new")}){Text("Новое")} } }
        if (vm.isLoading) item { LinearProgressIndicator(Modifier.fillMaxWidth()); Text("Дядя Витя читает воду...") }
        if (a == null && !vm.isLoading) item { GlassCard(Modifier.fillMaxWidth()) { Text("Анализа пока нет. Создай новое место."); AnimatedButton("Новое место", Modifier.fillMaxWidth()){ nav.navigate("new") } } }
        if (a != null) {
            item { BiteScoreView(a.biteScore, a.confidence, Modifier.fillMaxWidth()) }
            item { GlassCard(Modifier.fillMaxWidth()) { Text(a.verdict, fontWeight=FontWeight.Bold); Text("Лучшее время: ${a.bestTime}"); Text(a.vityaPhrase); Text(a.safety, style=MaterialTheme.typography.bodySmall) } }
            item { GlassCard(Modifier.fillMaxWidth()) { Text("Погода", fontWeight=FontWeight.Bold); Text("${a.weather.temperatureC}°C, ветер ${a.weather.windMs} м/с, ${a.weather.windDirection}"); Text("Давление ${a.weather.pressureMm} мм, ${a.weather.pressureTrend}. Влажность ${a.weather.humidity}%") } }
            item { GlassCard(Modifier.fillMaxWidth()) { Text("Риски", fontWeight=FontWeight.Bold); a.risks.forEach { Text("• $it") } } }
            item { GlassCard(Modifier.fillMaxWidth()) { Text("Мини-карта / точки", fontWeight=FontWeight.Bold); Text("Демо: здесь будет Google Maps / карта водоёма с точками, бровкой, ямой и стрелкой ветра.") } }
            item { Row(Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.spacedBy(12.dp)) { AnimatedButton("Выбрать рыбу", Modifier.weight(1f)){nav.navigate("fish")}; OutlinedButton({nav.navigate("shopping")}, Modifier.weight(1f).height(56.dp)){Text("Покупки")} } }
            item { GlassCard(Modifier.fillMaxWidth()) { Text("10 лайфхаков", fontWeight=FontWeight.Bold); a.lifehacks.forEachIndexed { i, h -> Text("${i+1}. $h") } } }
        }
    } }
}
