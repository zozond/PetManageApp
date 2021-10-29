package com.management.pet

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.management.pet.profiles.PetProfile
import com.management.pet.profiles.PetProfileRepository
import com.management.pet.profiles.adapters.PetProfileRoomRepository
import com.management.pet.schedules.Schedule
import com.management.pet.schedules.ScheduleRepository
import com.management.pet.schedules.adapters.ScheduleRoomRepository

class MemoryRoom {
    private val db: AppDatabase
    private val petProfileRepository: PetProfileRepository
    private val scheduleRepository: ScheduleRepository

    init {
        val context = ApplicationProvider.getApplicationContext<Context>()

        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()

        petProfileRepository = PetProfileRoomRepository(db.petProfileDAO())
        scheduleRepository = ScheduleRoomRepository(db.scheduleDAO())

        AppDatabase.setDatabase(db)
    }

    fun close() {
        db.close()
    }

    fun addPetProfile(petProfile: PetProfile) {
        petProfileRepository.add(petProfile)
    }

    fun addSchedule(schedule: Schedule) {
        scheduleRepository.add(schedule)
    }
}