package com.management.pet.schedules.entity

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDAO {
    @Query("SELECT * FROM scheduleentity")
    fun getAll(): Flow<List<ScheduleEntity>>

    @Insert
    fun insert(schedule: ScheduleEntity)

    @Update
    fun update(schedule: ScheduleEntity)

    @Delete
    fun delete(schedule: ScheduleEntity)
}