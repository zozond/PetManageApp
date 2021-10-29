package com.management.pet.schedules

import kotlinx.coroutines.flow.Flow

interface ScheduleViewModel {
    fun schedules(): Flow<List<Schedule>>
    fun add(schedule: Schedule)
    fun update(schedule: Schedule, change: ScheduleChange)
    fun remove(schedule: Schedule)
}