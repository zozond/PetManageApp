package com.management.pet

import android.app.AlarmManager
import android.content.Intent
import androidx.core.content.getSystemService
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.management.pet.repository.PetScheduler
import com.management.pet.repository.entity.Schedule
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.time.Duration
import java.time.LocalDate

@RunWith(AndroidJUnit4::class)
class ScheduleTests {
    private lateinit var scheduler: PetScheduler

    @Before
    fun setUp() {
        Intents.init()

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val alarmManager = context.getSystemService<AlarmManager>()!!
        val intent = Intent(context, AlarmReceiver::class.java)

        scheduler = PetScheduler(context, alarmManager, intent)
    }

    @Test
    fun scheduleShouldRegisteredInAlarmManager() {
        // given
        val schedule = Schedule("주사", LocalDate.now(), Duration.ZERO)

        // when
        scheduler.addSchedule(schedule)

        // then
        Intents.intended(hasComponent(AlarmReceiver::class.java.name))
    }

    @After
    fun tearDown() {
        Intents.release()
    }
}