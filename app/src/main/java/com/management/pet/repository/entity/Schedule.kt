package com.management.pet.repository.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class Schedule(
    val name: String,
    val schedule: LocalDate,
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}