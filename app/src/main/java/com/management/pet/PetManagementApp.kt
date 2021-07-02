package com.management.pet

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun PetManagementApp (
    petList : List<String>
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Pet Management App")
                }
            )
        }
    ) {
        renderPetList(petList)
    }
}

@Composable
fun renderPetList(petList : List<String>){
    Column() {
        Text(text = "Pet Lists")
        petList.forEach {
            Text(text = it)
        }
    }
}