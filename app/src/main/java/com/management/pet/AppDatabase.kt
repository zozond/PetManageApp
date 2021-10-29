package com.management.pet

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.*
import com.management.pet.profiles.entity.PetProfileEntity
import com.management.pet.profiles.entity.PetProfileEntityDAO
import com.management.pet.schedules.entity.ScheduleDAO
import com.management.pet.schedules.entity.ScheduleEntity

@Database(entities = [PetProfileEntity::class, ScheduleEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun petProfileDAO(): PetProfileEntityDAO
    abstract fun scheduleDAO(): ScheduleDAO

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pet_app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

        @VisibleForTesting
        fun setDatabase(db: AppDatabase) {
            synchronized(this) {
                INSTANCE = db
            }
        }
    }
}