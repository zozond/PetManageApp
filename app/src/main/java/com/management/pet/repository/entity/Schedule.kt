package com.management.pet.repository.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.Duration

@Entity
data class Schedule(
    val name: String,
    val schedule: LocalDate,
    val duration: Duration,
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
)