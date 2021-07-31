package com.management.pet

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.management.pet.entity.PetProfile
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EndToEndTests {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var app: ApplicationRunner
    private lateinit var resourceManager: ResourceManager

    @Before
    fun setUp() {
        app = ApplicationRunner(composeTestRule)
        resourceManager = ResourceManager()
    }

    // 펫 프로필(이름): 불러오기
    @Test
    fun loadPetProfiles() {
        val petProfiles = listOf(
            PetProfile("dog"),
            PetProfile("cat"),
            PetProfile("bird")
        )
        resourceManager.loadPetProfiles(petProfiles)

        app.openApp()
        for(pet in petProfiles){
            app.hasPetProfile(pet)
        }
    }

    // 펫 프로필(이름): 저장
    @Test
    fun loadPetProfilesAndThenSavePetProfile() {
        val petProfile = PetProfile("dog")

        app.openApp()
        resourceManager.registerPetProfile(petProfile)
        app.hasPetProfile(petProfile)
    }

    // 펫 프로필(이름): 삭제
    @Test
    fun loadPetProfilesAndThenRemovePetProfiles() {
        val petProfiles = listOf(PetProfile("dog"))
        val dog = PetProfile("dog")
        resourceManager.loadPetProfiles(petProfiles)

        app.openApp()
        resourceManager.removePetProfile(dog)
        app.hasNotPetProfile(dog)
    }

    // 펫 프로필(이름): 수정
    @Test
    fun loadPetProfilesAndThenUpdatePetProfiles() {
        // TODO("동일성 테스트가 필요합니다")
        val dog = PetProfile("dog")
        val doge = PetProfile("doge")
        val petProfiles = listOf(dog)

        resourceManager.loadPetProfiles(petProfiles)

        app.openApp()
        resourceManager.registerPet(pet)
        app.hasPet(pet)
    }
}