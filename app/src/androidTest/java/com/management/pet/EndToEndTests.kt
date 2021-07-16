package com.management.pet

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EndToEndTests {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    lateinit var app: Application
    lateinit var resourceManager: ResourceManager

    @Before
    fun setUp() {
        app = Application(composeTestRule);
        resourceManager = ResourceManager()
    }

    //    - 펫 프로필(이름): 불러오기
    @Test
    fun loadPetProfiles() {
        val pets = listOf("1", "2", "3")
        resourceManager.loadPets(pets)
        app.openApp()
        for(pet in pets){
            app.hasPet(pet)
        }
    }

    //     - 펫 프로필(이름): 저장
    @Test
    fun loadPetProfilesAndThenSavePetProfile() {
        val pet = "왜 이리 죽상이야?"
        app.openApp()
        resourceManager.registerPet(pet)
        app.hasPet(pet)
    }
}