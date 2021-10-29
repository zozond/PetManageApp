package com.management.pet.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun RegisterPetProfiles(
    navController: NavHostController
) {
    Column {
        Text(text = "register")
    }

    Button(onClick = { navController.navigate("home") }) {
        Text(text = "register button")
    }
}