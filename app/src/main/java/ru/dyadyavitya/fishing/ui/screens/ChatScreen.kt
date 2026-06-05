package ru.dyadyavitya.fishing.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.dyadyavitya.fishing.ui.components.PremiumBackground
import ru.dyadyavitya.fishing.viewmodel.AppViewModel

@Composable fun ChatScreen(nav: NavController, vm: AppViewModel, pad: PaddingValues) {
    var text by remember { mutableStateOf("") }
    PremiumBackground { Column(Modifier.padding(pad).padding(18.dp), verticalArrangement=Arrangement.spacedBy(10.dp)) {
        Text("Чат с Дядей Витей", style=MaterialTheme.typography.headlineMedium)
        LazyColumn(Modifier.weight(1f), verticalArrangement=Arrangement.spacedBy(8.dp)) { items(vm.chatMessages) { Card { Text(it, Modifier.padding(12.dp)) } } }
        Row(horizontalArrangement=Arrangement.spacedBy(8.dp)) { OutlinedTextField(text,{text=it},modifier=Modifier.weight(1f),label={Text("Спроси про место, рыбу или снасть")}); Button({vm.ask(text); text=""}){Text("▶") } }
    } }
}
