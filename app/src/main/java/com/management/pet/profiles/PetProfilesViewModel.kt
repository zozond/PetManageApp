package com.management.pet.profiles

import kotlinx.coroutines.flow.Flow

interface PetProfilesViewModel {
    fun petProfiles(): Flow<List<PetProfile>>
    fun add(profile: PetProfile)
    fun update(profile: PetProfile, change: PetProfileChange)
    fun remove(profile: PetProfile)
}