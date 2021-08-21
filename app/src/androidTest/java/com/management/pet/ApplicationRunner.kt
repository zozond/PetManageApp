package com.management.pet

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.management.pet.repository.entity.PetProfile
import com.management.pet.repository.entity.Schedule

class ApplicationRunner(
    private val composeRule: ComposeTestRule
) {
    fun openApp() {
        composeRule.waitForIdle()
    }

    fun hasPetProfile(petProfile: PetProfile) {
        composeRule.onNodeWithText(petProfile.name).assertIsDisplayed()
    }

    fun hasTitle(s: String) {
        composeRule.onNodeWithText(s).assertIsDisplayed()
    }

    fun hasNotPetProfile(petProfile: PetProfile) {
        composeRule.onNodeWithText(petProfile.name).assertDoesNotExist()
    }


    fun hasSchedule(schedule: Schedule) {
        composeRule.onNodeWithText(schedule.name).assertIsDisplayed()
    }

    fun hasScheduleName(s: String) {
        composeRule.onNodeWithText(s).assertIsDisplayed()
    }

    fun hasNotSchedule(schedule: Schedule) {
        composeRule.onNodeWithText(schedule.name).assertDoesNotExist()
    }
}