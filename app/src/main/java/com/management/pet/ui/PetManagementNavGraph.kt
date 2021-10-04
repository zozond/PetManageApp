package com.management.pet.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.management.pet.ui.screens.PetList
import com.management.pet.ui.screens.ScheduleList

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val SCHEDULE_ROUTE = "schedule"
    const val REGISTER_ROUTE = "register"
}

@Composable
fun PetManagementNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(MainDestinations.HOME_ROUTE) {
            Column {
                PetList(navController)
                ScheduleList(navController)
            }
        }
        composable(MainDestinations.REGISTER_ROUTE) {
            Register(navController)
        }
    }
}


@Composable
fun Register(
    navController: NavHostController
) {
    Column {
        Text(text = "register")
    }

    Button(onClick = { navController.navigate("home") }) {
        Text(text = "register button")
    }
}
