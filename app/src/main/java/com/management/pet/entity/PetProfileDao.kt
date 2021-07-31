package com.management.pet.entity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PetProfileDao {
    @Query("SELECT * FROM petProfile")
    fun getAll(): List<PetProfile?>?

    @Insert
    fun save(petProfile: PetProfile)

//    @Query
//    fun findProfileById(uid: Int): PetProfile?

//    fun save()
//    fun delete(petProfile: PetProfile)
}