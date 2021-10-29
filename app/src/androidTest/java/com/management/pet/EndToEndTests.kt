package com.management.pet

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.management.pet.profiles.PetProfileChange
import com.management.pet.profiles.PetProfile
import com.management.pet.schedules.Schedule
import com.management.pet.schedules.ScheduleChange
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.time.*

@RunWith(AndroidJUnit4::class)
class EndToEndTests {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var app: ApplicationRunner
    private lateinit var db: MemoryRoom

    @Before
    fun setUp() {
        db = MemoryRoom()
        app = ApplicationRunner(composeTestRule)
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun loadPetProfile() {
        val petProfile = PetProfile("dog")

        db.addPetProfile(petProfile)

        app.openApp()
        app.hasPetProfile(petProfile)
    }

    /**
     *  펫 프로필(이름): 저장
     * */
    @Test
    fun addPetProfile() {
        val petProfile = PetProfile("doge", 1)

        app.openApp()
        app.addPetProfile(petProfile)
        app.hasPetProfile(petProfile)
    }

    /**
     *  펫 프로필(이름): 삭제
     * */
    @Test
    fun addPetProfileAndRemoveIt() {
        val removedProfile = PetProfile("dog", 1)

        app.openApp()
        app.addPetProfile(removedProfile)
        app.removePetProfile(removedProfile)
        app.hasNotPetProfile(removedProfile)
    }

    /**
     *  펫 프로필(이름): 수정
     * */
    @Test
    fun addPetProfileAndUpdateIt() {
        val oldPetProfile = PetProfile("dog", 1)
        val change = PetProfileChange(name = "doge")
        val newPetProfile = oldPetProfile.assign(change)

        app.openApp()
        app.addPetProfile(oldPetProfile)
        app.updatePetProfile(oldPetProfile, change)
        app.hasPetProfile(newPetProfile)
    }

    @Test
    fun loadSchedule() {
        val schedule = Schedule("test", LocalDateTime.now(), Duration.ZERO, 1)

        db.addSchedule(schedule)

        app.openApp()
        app.hasSchedule(schedule)
    }

    /**
     *  - 스케줄(이름, 시간): 저장
     * */
    @Test
    fun addSchedule() {
        val schedule = Schedule("test", LocalDateTime.now(), Duration.ZERO, 1)

        app.openApp()
        app.addSchedule(schedule)
        app.hasSchedule(schedule)
    }

    /**
     *  - 스케줄(이름, 시간): 삭제
     * */
    @Test
    fun addScheduleAndRemoveIt() {
        val unusedSchedule = Schedule("unused", LocalDateTime.now(), Duration.ZERO, 1)

        app.openApp()
        app.addSchedule(unusedSchedule)
        app.removeSchedule(unusedSchedule)
        app.hasNotSchedule(unusedSchedule)
    }

    /**
     *  - 스케줄(이름, 시간): 수정
     * */
    @Test
    fun addScheduleAndUpdateIt() {
        val oldSchedule = Schedule("old", LocalDateTime.now(), Duration.ZERO, 1)
        val change = ScheduleChange("new")
        val newSchedule = oldSchedule.assign(change)

        app.openApp()
        app.addSchedule(oldSchedule)
        app.updateSchedule(oldSchedule, change)
        app.hasSchedule(newSchedule)
    }
}