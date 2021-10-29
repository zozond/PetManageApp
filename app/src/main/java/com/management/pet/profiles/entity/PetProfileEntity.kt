package com.management.pet.profiles.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PetProfileEntity(
    val name: String,
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
)