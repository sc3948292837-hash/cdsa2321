package ru.dyadyavitya.fishing.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.dyadyavitya.fishing.model.*
import ru.dyadyavitya.fishing.ui.components.*
import ru.dyadyavitya.fishing.viewmodel.AppViewModel

@Composable fun NewPlaceScreen(nav: NavController, vm: AppViewModel, pad: PaddingValues) {
    var lat by remember { mutableStateOf(vm.currentPlace.latitude.toString()) }
    var lon by remember { mutableStateOf(vm.currentPlace.longitude.toString()) }
    var water by remember { mutableStateOf(vm.currentPlace.waterType) }
    var date by remember { mutableStateOf(vm.currentPlace.tripDate) }
    var time by remember { mutableStateOf(vm.currentPlace.tripTime) }
    var method by remember { mutableStateOf(FishingMethod.SPINNING) }
    var exp by remember { mutableStateOf(Experience.MIDDLE) }
    var boat by remember { mutableStateOf(false) }
    var night by remember { mutableStateOf(false) }
    PremiumBackground { Column(Modifier.padding(pad).padding(18.dp).verticalScroll(rememberScrollState()), verticalArrangement=Arrangement.spacedBy(14.dp)) {
        Text("Новое место", style=MaterialTheme.typography.headlineMedium)
        GlassCard(Modifier.fillMaxWidth()) {
            OutlinedTextField(lat, {lat=it}, label={Text("Широта")}, modifier=Modifier.fillMaxWidth())
            OutlinedTextField(lon, {lon=it}, label={Text("Долгота")}, modifier=Modifier.fillMaxWidth())
            OutlinedTextField(water, {water=it}, label={Text("Тип водоёма")}, modifier=Modifier.fillMaxWidth())
            Row(horizontalArrangement=Arrangement.spacedBy(12.dp)) { OutlinedTextField(date,{date=it},label={Text("Дата")},modifier=Modifier.weight(1f)); OutlinedTextField(time,{time=it},label={Text("Время")},modifier=Modifier.weight(1f)) }
            Text("Способ ловли")
            SingleChoiceSegmentedButtonRow { FishingMethod.entries.forEachIndexed { i, m -> SegmentedButton(selected=method==m, onClick={method=m}, shape=SegmentedButtonDefaults.itemShape(i, FishingMethod.entries.size)) { Text(m.title) } } }
            Text("Опыт")
            SingleChoiceSegmentedButtonRow { Experience.entries.forEachIndexed { i, e -> SegmentedButton(selected=exp==e, onClick={exp=e}, shape=SegmentedButtonDefaults.itemShape(i, Experience.entries.size)) { Text(e.title) } } }
            Row { Checkbox(boat,{boat=it}); Text("Есть лодка", Modifier.padding(top=12.dp)); Spacer(Modifier.width(20.dp)); Checkbox(night,{night=it}); Text("Ночная рыбалка", Modifier.padding(top=12.dp)) }
            Text("Скриншот карты: в демо-версии отображается заглушка. Для боевого режима подключите ImageAnalysisService.")
            AnimatedButton("Дядя Витя, разбери место", Modifier.fillMaxWidth()) { vm.updatePlace(lat,lon,water,date,time,method,exp,boat,night); vm.analyze(); nav.navigate("analysis") }
        }
    } }
}
