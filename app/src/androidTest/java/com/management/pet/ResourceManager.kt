package com.management.pet

import com.management.pet.repository.DataSource
import com.management.pet.repository.MemoryPetProfileDataSource
import com.management.pet.repository.MemoryScheduleDataSource
import com.management.pet.profiles.PetProfile
import com.management.pet.schedules.Schedule

class ResourceManager {
    private val petDataSource: DataSource<MutableList<PetProfile>> = MemoryPetProfileDataSource
    private val scheduleDataSource: DataSource<MutableList<Schedule>> = MemoryScheduleDataSource

    fun loadPetProfiles(petProfiles: List<PetProfile>) {
        petDataSource.update {
            clear()
            addAll(petProfiles)
        }
    }

    fun loadSchedule(schedule: List<Schedule>) {
        scheduleDataSource.update {
            clear()
            addAll(schedule)
        }
    }
}