package com.management.pet.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.management.pet.repository.entity.PetProfile
import com.management.pet.repository.entity.PetProfileDAO

@Database(entities = [PetProfile::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun petProfileDAO(): PetProfileDAO
}