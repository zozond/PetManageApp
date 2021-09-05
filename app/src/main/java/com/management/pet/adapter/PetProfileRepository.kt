package com.management.pet.adapter

import com.management.pet.repository.PetProfileDataSource
import com.management.pet.repository.entity.PetProfile
import com.management.pet.repository.entity.PetProfileDAO

class PetProfileRepository(val dao: PetProfileDAO) {
    fun getAll(): List<PetProfile> {
        return listOf()
    }

    fun listen() {

    }
}