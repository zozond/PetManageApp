package com.management.pet

import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EndToEndTests {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    lateinit var app: Application

    @Before
    fun setUp() {
        app = Application(composeTestRule, InstrumentationRegistry.getInstrumentation().targetContext)
    }

    @Test
    fun getPetListAndShow(){
        app.hasPetList(PetList)
    }

    /**
     * 펫 프로필 입력, 저장 및 저장 성공
     * */
    @Test
    fun insertPetProfileThenRegisterSuccess() {
        val pet = "멍멍이"
        app.openApp()
        app.hasEmptyPets()
//        app.registerPet(pet)
        app.hasPet(pet)
    }

    /**
     * 스케쥴 입력, 저장하지 않은 상태로 등록취소
     * */
    @Test
    fun insertScheduleButCancel() {

    }

    /**
     * 스케쥴 입력, 저장 및 저장 실패
     */
    @Test
    fun insertScheduleThenRegisterFail() {

    }

    /**
     * 스케쥴 입력, 저장 및 저장 성공
     */
    @Test
    fun insertPetProfileThenSuccess() {

    }

    /**
     * 스케쥴 시간이 되면 알림 울림
     */
    @Test
    fun alarmAtScheduledTime() {

    }

    /**
     * 툴팁 정보 추가
     */
    @Test
    fun addToolTipInfo() {

    }

}