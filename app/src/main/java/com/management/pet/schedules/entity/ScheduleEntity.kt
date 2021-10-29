package com.management.pet.schedules.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.time.Duration
import java.time.LocalDateTime

@Entity
@TypeConverters(ScheduleConverter::class)
data class ScheduleEntity(
    val name: String,
    val schedule: LocalDateTime,
    val duration: Duration,
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
)