package com.management.pet.schedules.adapters

import com.management.pet.schedules.Schedule
import com.management.pet.schedules.ScheduleChange
import com.management.pet.schedules.ScheduleRepository
import com.management.pet.schedules.Scheduler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime

@ExperimentalCoroutinesApi
class ScheduleLiveDataViewModelTest {
    private val testCoroutine = TestCoroutineDispatcher()

    private lateinit var scheduler: Scheduler
    private lateinit var scheduleRepository: ScheduleRepository
    private lateinit var scheduleLiveDataViewModel: ScheduleLiveDataViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testCoroutine)

        scheduler = mock(Scheduler::class.java)
        scheduleRepository = mock(ScheduleRepository::class.java)
        scheduleLiveDataViewModel = ScheduleLiveDataViewModel(scheduleRepository, scheduler, testCoroutine)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testCoroutine.cleanupTestCoroutines()
    }

    @Test
    fun schedules() {
        // given

        // when
        scheduleLiveDataViewModel.schedules()

        // then
        verify(scheduleRepository).readAll()
    }

    @Test
    fun add() {
        // given

        // when
        scheduleLiveDataViewModel.schedules()

        // then
        verify(scheduleRepository).readAll()
    }

    @Test
    fun update() {
        // given
        val schedule = Schedule("old", LocalDateTime.now(), Duration.ZERO)
        val change = ScheduleChange("new")

        // when
        scheduleLiveDataViewModel.update(schedule, change)

        // then
        verify(scheduleRepository).update(schedule, change)
        verify(scheduler).updateSchedule(schedule, change)
    }

    @Test
    fun remove() {
        // given
        val schedule = Schedule("unused", LocalDateTime.now(), Duration.ZERO)

        // when
        scheduleLiveDataViewModel.remove(schedule)

        // then
        verify(scheduleRepository).remove(schedule)
        verify(scheduler).cancelSchedule(schedule)
    }
}