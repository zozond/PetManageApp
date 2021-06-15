package com.management.pet

import androidx.compose.ui.test.hasAnySibling
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EndToEndTests {
    /**
     * 펫 프로필 입력, 저장하지 않은 상태로 등록 취소
     */
    @Test
    fun insertPetProfileButCancel() {
        val app = Application()

        app.hasEmptyPets()
        app.registeringPet("멍멍이 건우")
        app.cancelRegistering()
        app.hasEmptyPets()

//        openApp()
//        hasEmptyPets() // 조회
//        registeringPet("멍멍이") // 펫
//        cancelRegistering()
//        hasEmptyPet()
    }

    /**
     * 펫 프로필 입력, 저장 및 저장 실패
     * */
    @Test
    fun insertPetProfileThenRegisterFail() {
//        openApp()
//        hasEmptyPets()
//        registeringPet("멍멍이")
//        failRegistering()
//        hasEmptyPet()
    }

    /**
     * 펫 프로필 입력, 저장 및 저장 성공
     * */
    @Test
    fun insertPetProfileThenRegisterSuccess() {
//        openApp()
//        hasEmptyPets()
//        registeringPet("멍멍이")
//        successRegistering()
//        hasOnePet()
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