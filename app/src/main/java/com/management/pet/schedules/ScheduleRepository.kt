package com.management.pet.schedules

import kotlinx.coroutines.flow.Flow

interface ScheduleRepository {
    fun readAll(): Flow<List<Schedule>>
    fun add(schedule: Schedule)
    fun update(schedule: Schedule, change: ScheduleChange)
    fun remove(schedule: Schedule)
}