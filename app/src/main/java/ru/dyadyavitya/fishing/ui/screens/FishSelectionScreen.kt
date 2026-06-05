package ru.dyadyavitya.fishing.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.dyadyavitya.fishing.model.FishSpecies
import ru.dyadyavitya.fishing.ui.components.*
import ru.dyadyavitya.fishing.viewmodel.AppViewModel

@Composable fun FishSelectionScreen(nav: NavController, vm: AppViewModel, pad: PaddingValues) {
    var selected by remember { mutableStateOf<FishSpecies?>(null) }
    val fish = vm.analysis?.fish.orEmpty()
    PremiumBackground { Column(Modifier.padding(pad).padding(18.dp), verticalArrangement=Arrangement.spacedBy(14.dp)) {
        Text("Выбор рыбы", style=MaterialTheme.typography.headlineMedium)
        LazyVerticalGrid(columns=GridCells.Adaptive(170.dp), horizontalArrangement=Arrangement.spacedBy(12.dp), verticalArrangement=Arrangement.spacedBy(12.dp), modifier=Modifier.weight(1f)) { items(fish) { FishCard(it){ selected=it } } }
        selected?.let { GlassCard(Modifier.fillMaxWidth()) { Text("${it.icon} ${it.name}", fontWeight=FontWeight.Bold); Text("Где искать: ${it.whereToFind}"); Text("На что: ${it.bait}"); Text("Тактика: ${it.tactic}"); Text("Ошибки: не шуметь, не стоять на одной точке часами, не ставить слишком грубую снасть.") } }
    } }
}
