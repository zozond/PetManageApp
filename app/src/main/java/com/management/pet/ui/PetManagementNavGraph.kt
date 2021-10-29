package com.management.pet.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.management.pet.ui.screens.PetList
import com.management.pet.ui.screens.RegisterPetProfiles
import com.management.pet.ui.screens.ScheduleList

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val SCHEDULE_ROUTE = "schedule"
    const val REGISTER_ROUTE = "register"
}

@Composable
fun PetManagementNavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(MainDestinations.HOME_ROUTE) {
            Column {
                PetList()
                ScheduleList()
            }
        }
        composable(MainDestinations.REGISTER_ROUTE) {
            RegisterPetProfiles(navController)
        }
    }
}
