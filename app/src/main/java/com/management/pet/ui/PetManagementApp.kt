package com.management.pet.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.management.pet.repository.MemoryPetProfileDataSource
import com.management.pet.repository.PetProfileDataSource
import com.management.pet.repository.entity.Schedule
import com.management.pet.state.PetListState
import java.time.ZoneId

@Composable
fun PetManagementApp () {
    val navController = rememberNavController()
    var petListState: PetListState by remember { mutableStateOf(PetListState(
        MemoryPetProfileDataSource.value)) }
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