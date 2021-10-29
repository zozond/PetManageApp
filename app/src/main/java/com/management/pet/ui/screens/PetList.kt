package com.management.pet.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.management.pet.profiles.PetProfile
import com.management.pet.profiles.PetProfileChange
import com.management.pet.profiles.PetProfileViewModel
import com.management.pet.profiles.adapters.PetProfileLiveDataViewModel
import com.management.pet.profiles.adapters.PetProfileViewModelFactory

@Composable
fun PetList(
    viewModel: PetProfileViewModel = viewModel<PetProfileLiveDataViewModel>(factory = PetProfileViewModelFactory(LocalContext.current))
) {
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