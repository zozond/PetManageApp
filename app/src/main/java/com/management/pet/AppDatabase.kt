package com.management.pet

import androidx.room.Database
import androidx.room.RoomDatabase
import com.management.pet.entity.PetProfile
import com.management.pet.entity.PetProfileDao

@Database(entities = [PetProfile::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun petProfileDao(): PetProfileDao
}

