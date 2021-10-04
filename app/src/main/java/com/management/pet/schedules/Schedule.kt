package com.management.pet.schedules

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.management.pet.profiles.PetProfile
import java.time.LocalDate
import java.time.Duration

@Entity
data class Schedule(
    val name: String,
    val schedule: LocalDate,
    val duration: Duration,
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
) {
    fun assign(change: ScheduleChange): Schedule {
        return Schedule(change.name ?: name, schedule, duration, uid=uid)
    }
}