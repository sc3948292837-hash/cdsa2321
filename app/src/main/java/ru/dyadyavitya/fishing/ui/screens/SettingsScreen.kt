package ru.dyadyavitya.fishing.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.dyadyavitya.fishing.model.SpeechMode
import ru.dyadyavitya.fishing.ui.components.*
import ru.dyadyavitya.fishing.viewmodel.AppViewModel

@Composable fun SettingsScreen(nav: NavController, vm: AppViewModel, pad: PaddingValues) {
    PremiumBackground { Column(Modifier.padding(pad).padding(18.dp), verticalArrangement=Arrangement.spacedBy(14.dp)) {
        Text("Настройки", style=MaterialTheme.typography.headlineMedium)
        GlassCard(Modifier.fillMaxWidth()) {
            Text("Стиль речи")
            Row { RadioButton(vm.speechMode==SpeechMode.CLEAN,{vm.speechMode=SpeechMode.CLEAN}); Text("Цензурный Дядя Витя", Modifier.padding(top=12.dp)) }
            Row { RadioButton(vm.speechMode==SpeechMode.ADULT,{vm.adultWarningAccepted=true; vm.speechMode=SpeechMode.ADULT}); Text("Дядя Витя 18+", Modifier.padding(top=12.dp)) }
            if (vm.speechMode==SpeechMode.ADULT) Text("Внимание: режим 18+ содержит грубую рыбацкую лексику, но без оскорблений, угроз и токсичности.")
        }
        GlassCard(Modifier.fillMaxWidth()) { Text("API-ключи"); Text("Сейчас включён демо-режим. Для полного анализа добавьте ключи в local.properties и подключите RealAIService / RealWeatherService.") }
    } }
}
