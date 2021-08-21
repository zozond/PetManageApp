package com.management.pet

import com.management.pet.repository.DataSource
import com.management.pet.repository.MemoryPetProfileDataSource
import com.management.pet.repository.MemoryScheduleDataSource
import com.management.pet.repository.entity.PetProfile
import com.management.pet.repository.entity.Schedule

class ResourceManager {
    private val petDataSource: DataSource<MutableList<PetProfile>> = MemoryPetProfileDataSource
    private val scheduleDataSource: DataSource<MutableList<Schedule>> = MemoryScheduleDataSource

    fun loadPetProfiles(petProfiles: List<PetProfile>) {
        petDataSource.update {
            clear()
            addAll(petProfiles)
        }
    }

    fun registerPetProfile(petProfile: PetProfile) {
        petDataSource.update {
            add(petProfile)
        }
    }

    fun removePetProfile(petProfile: PetProfile) {
        petDataSource.update {
            remove(petProfile)
        }
    }

    fun updatePetProfile(before: PetProfile, after: PetProfile) {
        petDataSource.update {
            val i = indexOf(before)
            set(i, after)
        }
    }


    fun loadSchedule(schedule: List<Schedule>) {
        scheduleDataSource.update {
            clear()
            addAll(schedule)
        }
    }

    fun registerSchedule(schedule: Schedule) {
        scheduleDataSource.update {
            add(schedule)
        }
    }

    fun removeSchedule(schedule: Schedule) {
        scheduleDataSource.update {
            remove(schedule)
        }
    }

    fun updateSchedule(before: Schedule, after: Schedule) {
        scheduleDataSource.update {
            val i = indexOf(before)
            set(i, after)
        }
    }
}