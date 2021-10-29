package com.management.pet.profiles.adapters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.management.pet.profiles.PetProfile
import com.management.pet.profiles.PetProfileChange
import com.management.pet.profiles.PetProfileRepository
import com.management.pet.profiles.PetProfileViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PetProfileLiveDataViewModel(
    private val repository: PetProfileRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : PetProfileViewModel, ViewModel() {
    override fun petProfiles(): Flow<List<PetProfile>> = repository.readAll()

    override fun add(profile: PetProfile) {
        viewModelScope.launch(dispatcher) {
            repository.add(profile)
        }
    }

    override fun update(profile: PetProfile, change: PetProfileChange) {
        viewModelScope.launch(dispatcher) {
            repository.update(profile, change)
        }
    }

    override fun remove(profile: PetProfile) {
        viewModelScope.launch(dispatcher) {
            repository.remove(profile)
        }
    }
}