package com.management.pet

class ResourceManager {
    private val petDataSource: DataSource<MutableList<String>> = MemoryPetDataSource

    fun loadPets(pets: List<String>) {
        petDataSource.update {
            clear()
            addAll(pets)
        }
    }

    fun registerPet(pet: String) {
        petDataSource.update {
            add(pet)
        }
    }
}