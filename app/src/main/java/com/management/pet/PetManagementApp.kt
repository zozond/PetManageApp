package com.management.pet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PetManagementApp () {
    val navController = rememberNavController()
    var petListState: PetListState by remember { mutableStateOf(PetListState(MemoryPetDataSource.value)) }
    val petDataSource: PetDataSource by remember {
        MemoryPetDataSource.observe {
            petListState = PetListState(it)
        }
        mutableStateOf(MemoryPetDataSource)
    }

    MainScreen(petListState, navController)
}

@Composable
fun MainScreen(petListState: PetListState, navHostController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Pet Management App")
                }
            )
        }
    ) {
        PetManagementNavGraph(navController = navHostController, petListState);
    }
}