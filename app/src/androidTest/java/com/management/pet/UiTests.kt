package com.management.pet

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UiTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    lateinit var app: ApplicationRunner

    @Before
    fun setUp() {
//        app = Application(composeTestRule, )
    }

    @Test
    fun hasTitle() {
        app.openApp()
        app.displayTitle("PetManagement")
    }

    @Test
    fun hasPetList(){
    }
}