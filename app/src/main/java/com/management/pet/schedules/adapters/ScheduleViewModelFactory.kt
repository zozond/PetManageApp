package com.management.pet.schedules.adapters

import android.app.AlarmManager
import android.content.Context
import androidx.core.content.getSystemService
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.management.pet.AppDatabase
import com.management.pet.schedules.ScheduleRepository
import com.management.pet.schedules.Scheduler

class ScheduleViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ScheduleLiveDataViewModel::class.java) -> {
                val db = AppDatabase.getDatabase(context)
                val alarmManager = context.getSystemService<AlarmManager>()!!
                val scheduleRepository: ScheduleRepository = ScheduleRoomRepository(db.scheduleDAO())
                val scheduler: Scheduler = AlarmScheduler(context, alarmManager)

                ScheduleLiveDataViewModel(scheduleRepository, scheduler) as T
            }
            else -> {
                throw IllegalArgumentException()
            }
        }
    }
}