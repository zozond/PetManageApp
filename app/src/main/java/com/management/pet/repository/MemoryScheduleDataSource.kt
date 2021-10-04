package com.management.pet.repository

import com.management.pet.schedules.Schedule


object MemoryScheduleDataSource: ScheduleDataSource {
    private val schedules = mutableListOf<Schedule>()
    private var scheduleListener: DataSourceListener<MutableList<Schedule>>? = null

    override fun observe(listener: DataSourceListener<MutableList<Schedule>>) {
        scheduleListener = listener
    }

    override fun update(block: MutableList<Schedule>.() -> Unit) {
        schedules.block()
        notifyChanged()
    }

    private fun notifyChanged() {
        scheduleListener?.invoke(schedules)
    }

    override val value: MutableList<Schedule>
        get() = schedules
}