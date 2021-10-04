package com.management.pet.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.lifecycle.asLiveData
import androidx.navigation.NavHostController
import com.management.pet.profiles.PetProfile
import com.management.pet.profiles.PetProfileChange
import com.management.pet.profiles.PetProfileRepository
import com.management.pet.profiles.PetProfilesViewModel
import com.management.pet.profiles.adapters.PetProfileMemoryRepository
import com.management.pet.profiles.adapters.PetProfilesLiveDataViewModel

@Composable
fun PetList(navController: NavHostController) {
    val repository: PetProfileRepository = PetProfileMemoryRepository()
    val viewModel: PetProfilesViewModel = PetProfilesLiveDataViewModel(repository)
    val petProfiles by viewModel.petProfiles().asLiveData().observeAsState()

    var id by remember { mutableStateOf(0) }
    var name by remember { mutableStateOf("") }

    Row {
        Column {
            Text(text = "Pet Lists")
            Row {
                petProfiles?.forEach {
                    Button(onClick = { } ){
                        Text(text = it.name)
                    }
                }
            }
            TextField(value = id.toString(), onValueChange = { id = it.toInt() }, Modifier.testTag("pet_id"))
            TextField(value = name, onValueChange = { name = it }, Modifier.testTag("pet_name"))
            Button(onClick = {viewModel.add(PetProfile(name, uid = id)); id = 0; name = "";}, Modifier.testTag("pet_add")) {
                Text(text = "+")
            }
            Button(onClick = {viewModel.remove(PetProfile(name, uid = id)); id = 0; name = "";}, Modifier.testTag("pet_remove")) {
                Text(text = "-")
            }
            Button(onClick = {viewModel.update(PetProfile(name, uid = id), PetProfileChange(name)); id = 0; name = "";}, Modifier.testTag("pet_update")) {
                Text(text = "update")
            }
        }
    }
}