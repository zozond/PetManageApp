package com.management.pet.schedules

interface Scheduler {
    fun addSchedule(schedule: Schedule)
    fun cancelSchedule(schedule: Schedule)
    fun updateSchedule(schedule: Schedule, change: ScheduleChange)
}