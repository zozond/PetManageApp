package com.management.pet.repository

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import com.management.pet.AlarmReceiver
import com.management.pet.repository.entity.Schedule
import java.time.ZoneId

class PetScheduler(
    private val context: Context,
    private val alarmManager: AlarmManager,
    private val intent: Intent) {

    private fun getPendingIntent(schedule: Schedule) : PendingIntent {
        val intent = Intent(intent)
        intent.putExtra("schedule_id", schedule.uid)
        return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    fun addSchedule(schedule: Schedule){
        val triggerTime =  schedule.schedule.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
        val repeat = schedule.duration.toMillis()
        val pendingIntent = getPendingIntent(schedule)
        when {
            repeat > 0 -> alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, triggerTime, repeat, pendingIntent)
            else -> alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent)
        }
    }

    fun cancelSchedule(schedule: Schedule) {
        try {
            alarmManager.cancel(getPendingIntent(schedule))
        } catch (e: Exception) {
            throw e
        }
    }
}