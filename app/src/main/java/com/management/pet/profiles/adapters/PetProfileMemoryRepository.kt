package com.management.pet.profiles.adapters

import com.management.pet.profiles.PetProfile
import com.management.pet.profiles.PetProfileChange
import com.management.pet.profiles.PetProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.sync.Mutex

val pets = mutableListOf<PetProfile>()

class PetProfileMemoryRepository: PetProfileRepository {
    private val mutex = Mutex()
    override fun readAll(): Flow<List<PetProfile>> = flow {
        while(true) {
            mutex.lock()

            emit(mutableListOf<PetProfile>().apply { addAll(pets) })
        }
    }

    override fun add(profile: PetProfile) {
        pets.add(profile)
        mutex.unlock()
    }

    override fun update(profile: PetProfile, change: PetProfileChange) {
        val i = pets.indexOf(profile)
        pets[i] = profile.assign(change)
        mutex.unlock()
    }

    override fun remove(profile: PetProfile) {
        pets.remove(profile)
        mutex.unlock()
    }

    fun reset() {
        pets.clear()
    }

    private fun PetProfile.assign(change: PetProfileChange): PetProfile {
        return PetProfile(change.name ?: name, uid=uid)
    }
}