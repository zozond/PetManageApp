package com.management.pet.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.management.pet.schedules.Schedule
import com.management.pet.schedules.ScheduleChange
import com.management.pet.schedules.ScheduleViewModel
import com.management.pet.schedules.adapters.ScheduleLiveDataViewModel
import com.management.pet.schedules.adapters.ScheduleViewModelFactory
import java.time.Duration
import java.time.LocalDateTime

@Composable
fun ScheduleList(
    viewModel: ScheduleViewModel = viewModel<ScheduleLiveDataViewModel>(factory = ScheduleViewModelFactory(LocalContext.current))
) {
    val schedules by viewModel.schedules().asLiveData().observeAsState()

    var id by remember { mutableStateOf(0) }
    var name by remember { mutableStateOf("") }

    Row {
        Column {
            Text(text = "Schedule Lists")
            Row {
                schedules?.forEach {
                    Button(onClick = { } ){
                        Text(text = it.name)
                    }
                }
            }
            TextField(value = id.toString(), onValueChange = { id = it.toInt() }, Modifier.testTag("schedule_id"))
            TextField(value = name, onValueChange = { name = it }, Modifier.testTag("schedule_name"))

            Button(onClick = {viewModel.add(Schedule(name, LocalDateTime.now(), Duration.ZERO, uid = id)); id = 0; name = "";}, Modifier.testTag("schedule_add")) {
                Text(text = "+")
            }
            Button(onClick = {viewModel.remove(Schedule(name, LocalDateTime.now(), Duration.ZERO, uid = id)); id = 0; name = "";}, Modifier.testTag("schedule_remove")) {
                Text(text = "-")
            }
            Button(onClick = {viewModel.update(Schedule(name, LocalDateTime.now(), Duration.ZERO, uid = id), ScheduleChange(name)); id = 0; name = "";}, Modifier.testTag("schedule_update")) {
                Text(text = "update")
            }
        }
    }
}