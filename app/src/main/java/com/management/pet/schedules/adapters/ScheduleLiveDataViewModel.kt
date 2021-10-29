package com.management.pet.schedules.adapters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.management.pet.schedules.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ScheduleLiveDataViewModel(
    private val repository: ScheduleRepository,
    private val scheduler: Scheduler,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ScheduleViewModel, ViewModel() {
    override fun schedules(): Flow<List<Schedule>> = repository.readAll()

    override fun add(schedule: Schedule) {
        viewModelScope.launch(dispatcher) {
            repository.add(schedule)
        }
        scheduler.addSchedule(schedule)
    }

    override fun update(schedule: Schedule, change: ScheduleChange) {
        viewModelScope.launch(dispatcher) {
            repository.update(schedule, change)
        }
        scheduler.updateSchedule(schedule, change)
    }

    override fun remove(schedule: Schedule) {
        viewModelScope.launch(dispatcher) {
            repository.remove(schedule)
        }
        scheduler.cancelSchedule(schedule)
    }
}