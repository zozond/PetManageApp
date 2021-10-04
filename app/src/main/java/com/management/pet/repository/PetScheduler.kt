package com.management.pet.repository

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.management.pet.AlarmReceiver
import com.management.pet.schedules.Schedule
import java.time.ZoneId

class PetScheduler (
    private val context: Context,
    private val alarmManager: AlarmManager
    ){

    private fun getPendingIntent(schedule: Schedule) : PendingIntent{
        val intent = Intent(context, AlarmReceiver::class.java)
        return PendingIntent.getBroadcast(context, schedule.uid, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    fun addSchedule(schedule: Schedule){
        val triggerTime =  schedule.schedule.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, getPendingIntent(schedule))
    }

    fun cancelSchedule(schedule: Schedule){
        val pendingIntent = getPendingIntent(schedule)
        alarmManager.cancel(pendingIntent)
        pendingIntent.cancel()
    }
}