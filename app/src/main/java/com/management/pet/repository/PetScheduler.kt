package com.management.pet.repository

import android.app.AlarmManager
import android.app.AlarmManager.AlarmClockInfo
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import com.management.pet.AlarmReceiver
import com.management.pet.repository.entity.Schedule
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
        alarmManager.cancel(getPendingIntent(schedule))
    }
//
//    fun getAlarm() : String{
//        return alarmManager.nextAlarmClock.toString()
//    }

    fun getAlarms() {
        var aci: AlarmClockInfo? = alarmManager.nextAlarmClock
        while (aci != null) {
            println(aci.showIntent.toString())
            println(String.format("Trigger time: %d", aci.triggerTime))
            aci = alarmManager.nextAlarmClock
        }
    }
}