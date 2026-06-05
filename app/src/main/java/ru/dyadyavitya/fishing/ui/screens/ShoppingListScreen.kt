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

@Composable fun ShoppingListScreen(nav: NavController, vm: AppViewModel, pad: PaddingValues) {
    val items = remember(vm.analysis) { mutableStateListOf(*vm.analysis?.shopping.orEmpty().toTypedArray()) }
    PremiumBackground { LazyColumn(Modifier.padding(pad).padding(18.dp), verticalArrangement=Arrangement.spacedBy(10.dp)) {
        item { Text("Что купить", style=MaterialTheme.typography.headlineMedium) }
        items(items) { item -> Card { Row(Modifier.fillMaxWidth().padding(12.dp)) { Checkbox(item.checked, { item.checked = it }); Column { Text(item.title); Text("${item.category} • ${item.priority}", style=MaterialTheme.typography.bodySmall) } } } }
        item { Button(onClick={}, modifier=Modifier.fillMaxWidth()) { Text("Поделиться списком") } }
    } }
}
