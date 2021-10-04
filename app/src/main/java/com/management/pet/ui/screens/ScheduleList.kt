package com.management.pet.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.management.pet.repository.MemoryScheduleDataSource
import com.management.pet.ui.state.PetListState
import com.management.pet.ui.state.ScheduleListState

@Composable
fun ScheduleList(
    navController: NavHostController
) {
    var scheduleListState: ScheduleListState by remember {
        mutableStateOf(ScheduleListState(MemoryScheduleDataSource.value))
    }
    val scheduleDataSource: MemoryScheduleDataSource by remember {
        MemoryScheduleDataSource.observe {
            scheduleListState = ScheduleListState(it)
        }
        mutableStateOf(MemoryScheduleDataSource)
    }

    Row {
        Column {
            Text(text = "Schedule Lists")
            Row {
                scheduleListState.schedules.forEach {
                    Button(onClick = { } ){
                        Text(text = it.name)
                    }
                }
                Button(onClick = { navController.navigate("register") }) {
                    Text(text = "+")
                }
            }
        }
    }
}