package com.management.pet

import com.management.pet.repository.DataSource
import com.management.pet.repository.MemoryPetProfileDataSource
import com.management.pet.repository.PetProfile

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

    fun updatePetProfile(before: PetProfile, after: PetProfile) {
        petDataSource.update {
            val i = indexOf(before)
            set(i, after)
        }
    }
}