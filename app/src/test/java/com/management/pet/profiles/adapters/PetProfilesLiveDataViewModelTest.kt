package com.management.pet.profiles.adapters

import com.management.pet.profiles.PetProfile
import com.management.pet.profiles.PetProfileChange
import com.management.pet.profiles.PetProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before

import org.junit.Test
import org.mockito.Mockito.*

@ExperimentalCoroutinesApi
class PetProfilesLiveDataViewModelTest {
    private val testCoroutine = TestCoroutineDispatcher()
    private lateinit var petProfilesLiveDataViewModel: PetProfileLiveDataViewModel
    private lateinit var petProfileRepository: PetProfileRepository

    @Before
    fun setUp() {
        Dispatchers.setMain(testCoroutine)

        petProfileRepository = mock(PetProfileRepository::class.java)
        petProfilesLiveDataViewModel = PetProfileLiveDataViewModel(petProfileRepository, testCoroutine)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testCoroutine.cleanupTestCoroutines()
    }

    @Test
    fun petProfiles() {
        // given

        // when
        petProfilesLiveDataViewModel.petProfiles()

        // then
        verify(petProfileRepository).readAll()
    }

    @Test
    fun add() {
        // given
        val petProfile = PetProfile("dog")

        // when
        petProfilesLiveDataViewModel.add(petProfile)

        // then
        verify(petProfileRepository).add(petProfile)
    }

    @Test
    fun update() {
        // given
        val petProfile = PetProfile("dog")
        val petProfileChange = PetProfileChange("doge")

        // when
        petProfilesLiveDataViewModel.update(petProfile, petProfileChange)

        // then
        verify(petProfileRepository).update(petProfile, petProfileChange)
    }

    @Test
    fun remove() {
        // given
        val petProfile = PetProfile("dog")

        // when
        petProfilesLiveDataViewModel.remove(petProfile)

        // then
        verify(petProfileRepository).remove(petProfile)
    }
}