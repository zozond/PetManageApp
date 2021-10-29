package com.management.pet.schedules.adapters

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.management.pet.AlarmReceiver
import com.management.pet.schedules.Schedule
import com.management.pet.schedules.ScheduleChange
import com.management.pet.schedules.Scheduler
import java.time.ZoneId

class AlarmScheduler (
    private val context: Context,
    private val alarmManager: AlarmManager
): Scheduler {
    companion object {
        const val ALARM_REQUEST_CODE = 1001
        const val EXTRA_SCHEDULE_ID = "SCHEDULE_ID"
    }

    private fun getPendingIntent(schedule: Schedule) : PendingIntent{
        val intent = Intent(context, AlarmReceiver::class.java)

        intent.putExtra(EXTRA_SCHEDULE_ID, schedule.uid)
        return PendingIntent.getBroadcast(context, ALARM_REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    override fun addSchedule(schedule: Schedule){
        val triggerTime = schedule.scheduleToEpochMillis()
        val pendingIntent = getPendingIntent(schedule)

        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, pendingIntent)
    }

    override fun cancelSchedule(schedule: Schedule){
        val pendingIntent = getPendingIntent(schedule)

        alarmManager.cancel(pendingIntent)
        pendingIntent.cancel()
    }

    override fun updateSchedule(schedule: Schedule, change: ScheduleChange) {
        val newSchedule = schedule.assign(change)
        val triggerTime = newSchedule.scheduleToEpochMillis()
        val pendingIntent = getPendingIntent(newSchedule)

        alarmManager.cancel(pendingIntent)
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, pendingIntent)
    }
}