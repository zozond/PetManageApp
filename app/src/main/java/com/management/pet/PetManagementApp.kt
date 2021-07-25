package com.management.pet

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PetManagementApp () {
    val navController = rememberNavController()
    var petListState: PetListState by remember { mutableStateOf(PetListState(MemoryPetProfileDataSource.value)) }
    val petDataSource: PetProfileDataSource by remember {
        MemoryPetProfileDataSource.observe {
            petListState = PetListState(it)
        }
        mutableStateOf(MemoryPetProfileDataSource)
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