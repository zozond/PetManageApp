package com.management.pet

import com.management.pet.entity.PetProfile

class ResourceManager {
    private val petDataSource: DataSource<MutableList<PetProfile>> = MemoryPetProfileDataSource

    fun loadPetProfiles(petProfiles: List<PetProfile>) {
        petDataSource.update {
            clear()
            addAll(petProfiles)
        }
    }

    fun registerPetProfile(petProfile: PetProfile) {
        petDataSource.update {
            add(petProfile)
        }
    }

    fun removePetProfile(petProfile: PetProfile) {
        petDataSource.update {
            remove(petProfile)
        }
    }

    fun updatePetProfile(petProfile: PetProfile, name: String) {
        petDataSource.update {
            val i = indexOf(petProfile)
            set(i, petProfile.setName(name))
        }
    }

    fun removePet(pet: String) {
        petDataSource.update {
            remove(pet)
        }
    }

    fun updatePet(pet: String, newPet: String) {
        petDataSource.update {
            val idx = indexOf(pet)
            set(idx, newPet)
        }
    }
}