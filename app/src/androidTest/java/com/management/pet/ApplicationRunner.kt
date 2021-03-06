package com.management.pet

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.management.pet.profiles.PetProfile
import com.management.pet.profiles.PetProfileChange
import com.management.pet.schedules.Schedule
import com.management.pet.schedules.ScheduleChange

class ApplicationRunner(
    private val composeRule: ComposeTestRule
) {
    fun openApp() {
        composeRule.waitForIdle()
    }

    fun hasPetProfile(petProfile: PetProfile) {
        composeRule
            .onNodeWithText(petProfile.name)
            .assertIsDisplayed()
    }

    fun hasTitle(s: String) {
        composeRule
            .onNodeWithText(s)
            .assertIsDisplayed()
    }

    fun hasNotPetProfile(petProfile: PetProfile) {
        composeRule
            .onNodeWithText(petProfile.name)
            .assertDoesNotExist()
    }

    fun updatePetProfile(petProfile: PetProfile, petProfileChange: PetProfileChange) {
        composeRule
            .onNodeWithTag("pet_id")
            .performTextInput(petProfile.uid.toString())
        composeRule
            .onNodeWithTag("pet_name")
            .performTextInput(petProfileChange.name ?: petProfile.name)
        composeRule
            .onNodeWithTag("pet_update")
            .performClick()
    }

    fun addPetProfile(petProfile: PetProfile) {
        composeRule
            .onNodeWithTag("pet_id")
            .performTextInput(petProfile.uid.toString())
        composeRule
            .onNodeWithTag("pet_name")
            .performTextInput(petProfile.name)
        composeRule
            .onNodeWithTag("pet_add")
            .performClick()
    }

    fun hasSchedule(schedule: Schedule) {
        composeRule
            .onNodeWithText(schedule.name)
            .assertIsDisplayed()
    }

    fun hasNotSchedule(schedule: Schedule) {
        composeRule
            .onNodeWithText(schedule.name)
            .assertDoesNotExist()
    }

    fun addSchedule(schedule: Schedule) {
        composeRule
            .onNodeWithTag("schedule_id")
            .performTextInput(schedule.uid.toString())
        composeRule
            .onNodeWithTag("schedule_name")
            .performTextInput(schedule.name)
        composeRule
            .onNodeWithTag("schedule_add")
            .performClick()
    }

    fun updateSchedule(schedule: Schedule, scheduleChange: ScheduleChange) {
        composeRule
            .onNodeWithTag("schedule_id")
            .performTextInput(schedule.uid.toString())
        composeRule
            .onNodeWithTag("schedule_name")
            .performTextInput(scheduleChange.name ?: schedule.name)
        composeRule
            .onNodeWithTag("schedule_update")
            .performClick()
    }

    fun removePetProfile(removedProfile: PetProfile) {
        composeRule
            .onNodeWithTag("pet_id")
            .performTextInput(removedProfile.uid.toString())
        composeRule
            .onNodeWithTag("pet_name")
            .performTextInput(removedProfile.name)
        composeRule
            .onNodeWithTag("pet_remove")
            .performClick()
    }

    fun removeSchedule(unusedSchedule: Schedule) {
        composeRule
            .onNodeWithTag("schedule_id")
            .performTextInput(unusedSchedule.uid.toString())
        composeRule
            .onNodeWithTag("schedule_name")
            .performTextInput(unusedSchedule.name)
        composeRule
            .onNodeWithTag("schedule_remove")
            .performClick()
    }
}