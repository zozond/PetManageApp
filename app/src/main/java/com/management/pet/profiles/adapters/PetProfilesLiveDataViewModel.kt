package com.management.pet.profiles.adapters

import androidx.lifecycle.ViewModel
import com.management.pet.profiles.PetProfile
import com.management.pet.profiles.PetProfileChange
import com.management.pet.profiles.PetProfileRepository
import com.management.pet.profiles.PetProfilesViewModel
import kotlinx.coroutines.flow.Flow

class PetProfilesLiveDataViewModel(private val repository: PetProfileRepository) : PetProfilesViewModel, ViewModel() {
    override fun petProfiles(): Flow<List<PetProfile>> = repository.readAll()

    override fun add(profile: PetProfile) {
        repository.add(profile)
    }

    override fun update(profile: PetProfile, change: PetProfileChange) {
        repository.update(profile, change)
    }

    override fun remove(profile: PetProfile) {
        repository.remove(profile)
    }
}