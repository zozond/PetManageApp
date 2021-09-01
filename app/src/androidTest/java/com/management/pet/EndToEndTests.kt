package com.management.pet

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.management.pet.repository.entity.PetProfile
import com.management.pet.repository.entity.Schedule
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
    private lateinit var resourceManager: ResourceManager

    val profiles = listOf(PetProfile("dog"), PetProfile("cat"), PetProfile("bird"))

    val schedules = listOf(
            Schedule("first", LocalDate.now(), Duration.ZERO),
            Schedule("second", LocalDate.now(), Duration.ZERO),
            Schedule("third", LocalDate.now(), Duration.ZERO)
        )

    @Before
    fun setUp() {
        app = ApplicationRunner(composeTestRule)
        resourceManager = ResourceManager()
    }

    /**
     * 펫 프로필(이름): 불러오기
     * */
    @Test
    fun loadPetProfiles() {
        resourceManager.loadPetProfiles(profiles)

        app.openApp()
        for(pet in profiles){
            app.hasPetProfile(pet)
        }
    }

    /**
     *  펫 프로필(이름): 저장
     * */
    @Test
    fun loadPetProfilesAndThenSavePetProfile() {
        val petProfile = PetProfile("doge")

        app.openApp()
        resourceManager.registerPetProfile(petProfile)
        app.hasPetProfile(petProfile)
    }

    /**
     *  펫 프로필(이름): 삭제
     * */
    @Test
    fun loadPetProfilesAndThenRemovePetProfiles() {
        val removedProfile = profiles.get(0)
        resourceManager.loadPetProfiles(profiles)

        app.openApp()
        resourceManager.removePetProfile(removedProfile)
        app.hasNotPetProfile(removedProfile)
    }

    /**
     *  펫 프로필(이름): 수정
     * */
    @Test
    fun loadPetProfilesAndThenUpdatePetProfiles() {
        // TODO("동일성 테스트가 필요합니다")
        val beforeProfile = profiles.get(0)
        val afterProfile = PetProfile("doge")

        resourceManager.loadPetProfiles(profiles)
        app.openApp()

        resourceManager.updatePetProfile(beforeProfile, afterProfile)
        app.hasNotPetProfile(beforeProfile)
        app.hasPetProfile(afterProfile)
    }

    /**
     *  - 스케줄(이름, 시간): 저장
     * */
    @Test
    fun saveSchedule() {
        val schedule = Schedule("test", LocalDate.now(), Duration.ZERO);

        app.openApp()
        resourceManager.registerSchedule(schedule)
        app.hasSchedule(schedule)

    }

    /**
     *  - 스케줄(이름, 시간): 불러오기
     * */
    @Test
    fun loadSchedule() {
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
        val removedSchedule = schedules.get(0)
        resourceManager.loadSchedule(schedules)

        app.openApp()
        resourceManager.removeSchedule(removedSchedule)
        app.hasNotSchedule(removedSchedule)
    }

    /**
     *  - 스케줄(이름, 시간): 수정
     * */
    @Test
    fun modifySchedule() {
        // TODO("동일성 테스트가 필요합니다")
        val beforeSchedule = schedules.get(0)
        val afterSchedule = Schedule("forth", LocalDate.now(), Duration.ZERO)

        resourceManager.loadSchedule(schedules)
        app.openApp()

        resourceManager.updateSchedule(beforeSchedule, afterSchedule)
        app.hasNotSchedule(beforeSchedule)
        app.hasSchedule(afterSchedule)
    }
}