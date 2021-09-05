package com.management.pet.repository.entity

import androidx.room.*

@Dao
interface PetProfileDAO {
    @Query("SELECT * FROM petProfile")
    fun getAll(): List<PetProfile>

    @Insert
    fun addAll(petProfiles: List<PetProfile>)

    @Insert
    fun add(petProfile: PetProfile)

    @Delete
    fun remove(petProfile: PetProfile)

    @Update
    fun update(petProfile: PetProfile)
}
