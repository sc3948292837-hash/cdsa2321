package ru.dyadyavitya.fishing.ui

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import ru.dyadyavitya.fishing.ui.screens.*
import ru.dyadyavitya.fishing.viewmodel.AppViewModel

@Composable
fun DyadyaVityaApp(vm: AppViewModel = viewModel()) {
    val nav = rememberNavController()
    Scaffold { pad ->
        NavHost(navController = nav, startDestination = "home") {
            composable("home") { HomeScreen(nav, vm, pad) }
            composable("new") { NewPlaceScreen(nav, vm, pad) }
            composable("analysis") { AnalysisScreen(nav, vm, pad) }
            composable("fish") { FishSelectionScreen(nav, vm, pad) }
            composable("shopping") { ShoppingListScreen(nav, vm, pad) }
            composable("stories") { StoriesScreen(nav, pad) }
            composable("chat") { ChatScreen(nav, vm, pad) }
            composable("settings") { SettingsScreen(nav, vm, pad) }
        }
    }
}
