package ru.dyadyavitya.fishing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.dyadyavitya.fishing.ui.DyadyaVityaApp
import ru.dyadyavitya.fishing.ui.theme.DyadyaVityaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { DyadyaVityaTheme { DyadyaVityaApp() } }
    }
}
