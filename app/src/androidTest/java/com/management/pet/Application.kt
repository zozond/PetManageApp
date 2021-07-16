package com.management.pet

import android.content.Context
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule

class Application(
    private val composeRule: ComposeTestRule
) {
    fun openApp() {
        composeRule.waitForIdle()
    }

    fun hasPet(pet: String) {
        composeRule.onNodeWithText(pet).assertIsDisplayed()
    }

    fun hasTitle(s: String) {
        composeRule.onNodeWithText(s).assertIsDisplayed()
    }
}