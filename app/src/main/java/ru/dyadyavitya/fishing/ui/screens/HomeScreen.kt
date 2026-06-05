package ru.dyadyavitya.fishing.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.dyadyavitya.fishing.ui.components.*
import ru.dyadyavitya.fishing.viewmodel.AppViewModel

@Composable fun HomeScreen(nav: NavController, vm: AppViewModel, pad: PaddingValues) {
    PremiumBackground {
        Column(Modifier.padding(pad).padding(18.dp).fillMaxSize(), horizontalAlignment=Alignment.CenterHorizontally, verticalArrangement=Arrangement.spacedBy(16.dp)) {
            VityaAvatarView()
            Text("Дядя Витя", style=MaterialTheme.typography.headlineLarge, fontWeight=FontWeight.ExtraBold)
            Text("AI-помощник рыбака для телефона и планшета")
            if (vm.demoMode) AssistChip(onClick={}, label={ Text("Демо-режим: подключите API-ключи для полноценного анализа") })
            GlassCard(Modifier.fillMaxWidth()) { Text("Ну что, рыбачок, куда едем? Показывай точку, будем разбираться, где там рыба сидит и чем её уговаривать.") }
            LazyVerticalGrid(columns=GridCells.Adaptive(220.dp), modifier=Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.spacedBy(12.dp), verticalArrangement=Arrangement.spacedBy(12.dp)) {
                item { AnimatedButton("Новое место", Modifier.fillMaxWidth()) { nav.navigate("new") } }
                item { AnimatedButton("Мои места", Modifier.fillMaxWidth()) { nav.navigate("analysis") } }
                item { AnimatedButton("Спросить Дядю Витю", Modifier.fillMaxWidth()) { nav.navigate("chat") } }
                item { AnimatedButton("Истории", Modifier.fillMaxWidth()) { nav.navigate("stories") } }
                item { OutlinedButton(onClick={ nav.navigate("settings") }, modifier=Modifier.fillMaxWidth().height(56.dp)) { Text("Настройки") } }
            }
        }
    }
}
