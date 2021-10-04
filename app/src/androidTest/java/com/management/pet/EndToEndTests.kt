package com.management.pet

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.management.pet.profiles.PetProfileChange
import com.management.pet.profiles.PetProfile
import com.management.pet.profiles.PetProfileRepository
import com.management.pet.profiles.adapters.PetProfileMemoryRepository
import com.management.pet.schedules.Schedule
import com.management.pet.schedules.ScheduleChange
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
    private lateinit var petProfileRepository: PetProfileRepository
    private lateinit var resourceManager: ResourceManager

    @Before
    fun setUp() {
        app = ApplicationRunner(composeTestRule)
        petProfileRepository = PetProfileMemoryRepository().apply { reset() }
        resourceManager = ResourceManager()
    }

    /**
     * 펫 프로필(이름): 불러오기
     * */
    @Test
    fun loadPetProfiles() {
        val profiles = listOf(
            PetProfile("dog"),
            PetProfile("cat"),
            PetProfile("bird")
        )

        profiles.forEach(petProfileRepository::add)
        app.openApp()
        for(pet in profiles){
            app.hasPetProfile(pet)
        }
    }

    /**
     *  펫 프로필(이름): 저장
     * */
    @Test
    fun addPetProfile() {
        val petProfile = PetProfile("doge")

        app.openApp()
        app.addPetProfile(petProfile)
        app.hasPetProfile(petProfile)
    }

    /**
     *  펫 프로필(이름): 삭제
     * */
    @Test
    fun addPetProfileAndRemoveIt() {
        val removedProfile = PetProfile("dog")

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
        val profile = PetProfile("dog")
        val change = PetProfileChange(name = "doge")

        app.openApp()
        app.addPetProfile(profile)
        app.updatePetProfile(profile, change)
        app.hasPetProfileWithChange(profile, change)
    }

    /**
     *  - 스케줄(이름, 시간): 저장
     * */
    @Test
    fun saveSchedule() {
        val schedule = Schedule("test", LocalDate.now(), Duration.ZERO)

        app.openApp()
        app.addSchedule(schedule)
        app.hasSchedule(schedule)
    }

    /**
     *  - 스케줄(이름, 시간): 불러오기
     * */
    @Test
    fun loadSchedule() {
        val schedules = listOf(
            Schedule("first", LocalDate.now(), Duration.ZERO),
            Schedule("second", LocalDate.now(), Duration.ZERO),
            Schedule("third", LocalDate.now(), Duration.ZERO)
        )

        resourceManager.loadSchedule(schedules)
        app.openApp()
        for(schedule in schedules){
            app.hasSchedule(schedule)
        }
    }

    /**
     *  - 스케줄(이름, 시간): 삭제
     * */
    @Test
    fun removeSchedule() {
        val unusedSchedule = Schedule("unused", LocalDate.now(), Duration.ZERO)

        app.openApp()
        app.addSchedule(unusedSchedule)
        app.removeSchedule(unusedSchedule)
        app.hasNotSchedule(unusedSchedule)
    }

    /**
     *  - 스케줄(이름, 시간): 수정
     * */
    @Test
    fun modifySchedule() {
        val oldSchedule = Schedule("old", LocalDate.now(), Duration.ZERO)
        val change = ScheduleChange(name="new")
        val newSchedule = oldSchedule.assign(change)

        app.openApp()
        app.addSchedule(oldSchedule)
        app.updateSchedule(newSchedule)
        app.hasSchedule(newSchedule)
    }
}