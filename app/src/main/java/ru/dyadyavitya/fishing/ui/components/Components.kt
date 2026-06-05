package ru.dyadyavitya.fishing.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.dyadyavitya.fishing.model.FishSpecies

@Composable fun PremiumBackground(content: @Composable BoxScope.() -> Unit) {
    Box(Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(MaterialTheme.colorScheme.background, MaterialTheme.colorScheme.surface)))) { AnimatedWater(); content() }
}

@Composable fun AnimatedWater() {
    val t by rememberInfiniteTransition(label="water").animateFloat(0f, 1f, infiniteRepeatable(tween(3500), RepeatMode.Reverse), label="wave")
    Canvas(Modifier.fillMaxSize()) {
        val y = size.height * (0.78f + t * 0.02f)
        drawCircle(Color(0x223A7C72), radius = size.width * .75f, center = Offset(size.width * .15f, y))
        drawCircle(Color(0x18D7A84D), radius = size.width * .45f, center = Offset(size.width * .95f, y + 80))
    }
}

@Composable fun GlassCard(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Card(modifier, shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface.copy(alpha=.90f)), elevation = CardDefaults.cardElevation(6.dp)) { Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp), content = content) }
}

@Composable fun VityaAvatarView(modifier: Modifier = Modifier) {
    Box(modifier.size(128.dp).clip(CircleShape).background(Brush.radialGradient(listOf(Color(0xFFD7A84D), Color(0xFF0B1F2A)))), contentAlignment = Alignment.Center) {
        Text("🎣", fontSize = 54.sp)
    }
}

@Composable fun AnimatedButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(onClick, modifier.height(56.dp).then(modifier), shape = RoundedCornerShape(18.dp)) { Text(text, fontWeight = FontWeight.Bold) }
}

@Composable fun BiteScoreView(score: Int, confidence: Int, modifier: Modifier = Modifier) {
    GlassCard(modifier) {
        Text("Индекс клёва", fontWeight = FontWeight.Bold)
        Box(Modifier.fillMaxWidth().height(110.dp), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(progress = { score / 100f }, modifier = Modifier.size(96.dp), strokeWidth = 10.dp)
            Text("$score%", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
        Text("Уверенность анализа: $confidence%")
    }
}

@Composable fun FishCard(fish: FishSpecies, onClick: () -> Unit) {
    Card(onClick=onClick, shape=RoundedCornerShape(20.dp), colors=CardDefaults.cardColors(containerColor=MaterialTheme.colorScheme.surface)) {
        Column(Modifier.padding(14.dp), verticalArrangement=Arrangement.spacedBy(6.dp)) { Text(fish.icon, fontSize=30.sp); Text(fish.name, fontWeight=FontWeight.Bold); Text("Вероятность: ${fish.probability}%"); Text(fish.bait, style=MaterialTheme.typography.bodySmall) }
    }
}
