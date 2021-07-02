package com.management.pet

import android.content.Context
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule

class Application(
    private val composeRule: ComposeTestRule,
    private val context: Context
) {

    fun hasEmptyPets() {
        composeRule
            .onNode(hasTestTag("Pets"))
            .onChildren()
            .assertCountEquals(0)
    }

    fun openApp() {

    }

    fun hasPet(pet: String) {
        composeRule.onNodeWithText(pet).assertExists()
    }

    fun hasTitle(s: String) {
        composeRule.onNodeWithText(s).assertIsDisplayed()
    }

    fun hasPetList(l: List<String>) {
        composeRule.onNodeWithText("Pet Lists").assertExists()
        for(i in l){
            composeRule.onNodeWithText(i).assertExists()
        }
    }

}