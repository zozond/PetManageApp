package com.management.pet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val REGISTER_ROUTE = "register"
}

@Composable
fun PetManagementNavGraph(
    navController: NavHostController,
    petList : PetListState
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(MainDestinations.HOME_ROUTE) {
            PetList(petListState = petList, navController = navController)
        }
        composable(MainDestinations.REGISTER_ROUTE) {
            Register(navController = navController)
        }
    }
}

@Composable
fun Register(
    navController: NavHostController
) {
    Column() {
        Text(text = "register")
    }

    Button(onClick = { navController.navigate("home") }) {
        Text(text = "register button")
    }
}

@Composable
fun PetList(petListState: PetListState, navController: NavHostController) {
    Row() {
        Column() {
            Text(text = "Pet Lists")
            Row() {
                petListState.pets.forEach {
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