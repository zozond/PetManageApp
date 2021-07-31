package com.management.pet

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.management.pet.repository.PetProfile
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

    val profiles = listOf(PetProfile("dog"), PetProfile("cat"), PetProfile("bird"))

    @Before
    fun setUp() {
        app = ApplicationRunner(composeTestRule)
        resourceManager = ResourceManager()
    }

    /**
     * 펫 프로필(이름): 불러오기
     * */
    @Test
    fun loadPetProfiles() {
        resourceManager.loadPetProfiles(profiles)

        app.openApp()
        for(pet in profiles){
            app.hasPetProfile(pet)
        }
    }

    /**
     *  펫 프로필(이름): 저장
     * */
    @Test
    fun loadPetProfilesAndThenSavePetProfile() {
        val petProfile = PetProfile("doge")

        app.openApp()
        resourceManager.registerPetProfile(petProfile)
        app.hasPetProfile(petProfile)
    }

    /**
     *  펫 프로필(이름): 삭제
     * */
    @Test
    fun loadPetProfilesAndThenRemovePetProfiles() {
        val removedProfile = profiles.get(0)
        resourceManager.loadPetProfiles(profiles)

        app.openApp()
        resourceManager.removePetProfile(removedProfile)
        app.hasNotPetProfile(removedProfile)
    }

    /**
     *  펫 프로필(이름): 수정
     * */
    @Test
    fun loadPetProfilesAndThenUpdatePetProfiles() {
        // TODO("동일성 테스트가 필요합니다")
        val beforeProfile = profiles.get(0)
        val afterProfile = PetProfile("doge")

        resourceManager.loadPetProfiles(profiles)
        app.openApp()

        resourceManager.updatePetProfile(beforeProfile, afterProfile)
        app.hasNotPetProfile(beforeProfile)
        app.hasPetProfile(afterProfile)
    }
}