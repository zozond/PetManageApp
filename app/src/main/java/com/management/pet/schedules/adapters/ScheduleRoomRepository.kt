package com.management.pet.schedules.adapters

import com.management.pet.schedules.Schedule
import com.management.pet.schedules.ScheduleChange
import com.management.pet.schedules.ScheduleRepository
import com.management.pet.schedules.entity.ScheduleDAO
import com.management.pet.schedules.entity.ScheduleEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ScheduleRoomRepository(
    private val dao: ScheduleDAO
): ScheduleRepository {
    override fun readAll(): Flow<List<Schedule>> {
        return dao.getAll().map { list -> list.map { it.toSchedule() }  }
    }

    override fun add(schedule: Schedule) {
        dao.insert(schedule.toEntity())
    }

    override fun update(schedule: Schedule, change: ScheduleChange) {
        dao.update(schedule.assign(change).toEntity())
    }

    override fun remove(schedule: Schedule) {
        dao.delete(schedule.toEntity())
    }

    private fun Schedule.toEntity(): ScheduleEntity {
        return ScheduleEntity(name, schedule, duration, uid)
    }

    private fun ScheduleEntity.toSchedule(): Schedule {
        return Schedule(name, schedule, duration, uid)
    }
}