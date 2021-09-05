package com.management.pet.repository.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PetProfile(
    val name: String,
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
) {
    fun setName(name: String): PetProfile {
        return PetProfile(name, uid)
    }
}