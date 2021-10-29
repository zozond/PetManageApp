package com.management.pet.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*

@Composable
fun PetManagementApp () {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Pet Management App")
                }
            )
        }
    ) {
        PetManagementNavGraph()
    }
}