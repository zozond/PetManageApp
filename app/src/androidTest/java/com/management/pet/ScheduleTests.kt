package com.management.pet

import android.app.AlarmManager
import androidx.core.content.getSystemService
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.management.pet.repository.PetScheduler
import com.management.pet.repository.entity.Schedule
import org.junit.Test
import org.junit.runner.RunWith
import java.time.Duration
import java.time.LocalDate

@RunWith(AndroidJUnit4::class)
class ScheduleTests {

    @Test
    fun registerScheduleThenScheduleCancelTest(){
        // given
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val alarmManager = context.getSystemService<AlarmManager>()!!
        val petScheduler = PetScheduler(context, alarmManager)
        val schedule = Schedule("test", LocalDate.now(), Duration.ZERO);

        // when
        petScheduler.addSchedule(schedule)
//        print(petScheduler.getAlarm());

        // then
        petScheduler.cancelSchedule(schedule)
//        petScheduler.getAlarms()

        // expect no/new error
    }
}