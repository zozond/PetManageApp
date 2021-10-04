package com.management.pet.profiles.entity

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PetProfileEntityDAO {
    @Query("SELECT * FROM petprofileentity")
    fun getAll(): Flow<List<PetProfileEntity>>

    @Insert
    fun insert(petProfile: PetProfileEntity)

    @Update
    fun update(petProfile: PetProfileEntity)

    @Delete
    fun delete(petProfile: PetProfileEntity)
}
