package com.management.pet.schedules

import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneId

data class Schedule(
    val name: String,
    val schedule: LocalDateTime,
    val duration: Duration,
    var uid: Int = 0
) {
    fun assign(change: ScheduleChange): Schedule {
        return Schedule(change.name ?: name, schedule, duration, uid=uid)
    }

    fun scheduleToEpochMillis(): Long {
        return schedule.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
    }
}