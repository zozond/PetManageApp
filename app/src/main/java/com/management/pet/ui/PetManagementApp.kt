package com.management.pet.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PetManagementApp () {
    val navController = rememberNavController()
    Main(navController)
}

@Composable
fun Main(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Pet Management App")
                }
            )
        }
    ) {
        PetManagementNavGraph(navHostController)
    }
}