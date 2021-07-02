package com.management.pet

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule

class Application(
    private val composeRule: ComposeTestRule
) {

    fun hasEmptyPets() {
        composeRule
            .onNode(hasTestTag("Pets"))
            .onChildren()
            .assertCountEquals(0)
    }

    fun openApp() {
        // do nothing
    }

    fun hasPet(pet: String) {
        composeRule.onNodeWithText(pet).assertExists()
    }

//    fun registerPet(pet: String) {
//        val petRepository: PetRepository = PetSharedPreference()
//        petRepository.add(pet)
//    }

    fun hasTitle(s: String) {
        composeRule.onNodeWithText(s).assertIsDisplayed()
    }

    fun hasPetList() {
        composeRule.onNodeWithText("Pet List").assertExists()
    }

}