package com.management.pet.schedules.adapters

import com.management.pet.schedules.Schedule
import com.management.pet.schedules.ScheduleChange
import com.management.pet.schedules.ScheduleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.sync.Mutex

val schedules = mutableListOf<Schedule>()

class ScheduleMemoryRepository: ScheduleRepository {
    private val mutex = Mutex()
    override fun readAll(): Flow<List<Schedule>> = flow {
        while(true) {
            mutex.lock()

            emit(mutableListOf<Schedule>().apply { addAll(schedules) })
        }
    }

    override fun add(schedule: Schedule) {
        schedules.add(schedule)
        mutex.unlock()
    }

    override fun update(schedule: Schedule, change: ScheduleChange) {
        val i = schedules.indexOf(schedule)
        schedules[i] = schedule.assign(change)
        mutex.unlock()
    }

    override fun remove(schedule: Schedule) {
        schedules.remove(schedule)
        mutex.unlock()
    }
}