package com.management.pet

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.content.getSystemService
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.management.pet.repository.PetScheduler
import com.management.pet.repository.entity.Schedule
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.time.Duration
import java.time.LocalDate

/**
 * Intents 사용 보류
 * 이유 -> 자료없음.
 */

@RunWith(AndroidJUnit4::class)
class ScheduleTests {
    private lateinit var scheduler: PetScheduler
    private lateinit var context: Context
    @Before
    fun setUp() {
//        Intents.init()
        context = InstrumentationRegistry.getInstrumentation().targetContext
        val alarmManager = context.getSystemService<AlarmManager>()!!
        scheduler = PetScheduler(context, alarmManager)
    }

//      @Test
//      fun scheduleShouldRegisteredInAlarmManager() {
//    // given
//          val schedule = Schedule("주사", LocalDate.now(), Duration.ZERO)
//
//    // when
//          scheduler.addSchedule(schedule)
//
//    // then
//          Intents.intended(hasComponent(AlarmReceiver::class.java.name))
//      }
//
    @After
    fun tearDown() {
//        Intents.release()
    }

    @Test
    fun registerScheduleTest(){
        // given
        val schedule = Schedule("test", LocalDate.now(), Duration.ZERO)

        // when
        scheduler.addSchedule(schedule)

        // then
        Assert.assertEquals(true, isSetSchedule(schedule))
    }

    @Test
    fun cancelScheduleTest(){
        // given
        val schedule = Schedule("test", LocalDate.now(), Duration.ZERO)

        // when
        scheduler.addSchedule(schedule)
        scheduler.cancelSchedule(schedule)

        // then
        Assert.assertEquals(false, isSetSchedule(schedule))
    }

    private fun isSetSchedule(schedule: Schedule) : Boolean {
        val intent = Intent(context, AlarmReceiver::class.java)
        // null = 설정된 알람 없음
        // not null = 설정된 알람 있음
        return PendingIntent.getBroadcast(context, schedule.uid, intent, PendingIntent.FLAG_NO_CREATE) != null
    }
}