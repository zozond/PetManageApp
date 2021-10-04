package com.management.pet.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.management.pet.profiles.entity.PetProfileEntity
import com.management.pet.profiles.entity.PetProfileEntityDAO

@Database(entities = [PetProfileEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun petProfileDAO(): PetProfileEntityDAO
}