package com.management.pet

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule

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
}