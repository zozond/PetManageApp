package com.management.pet.repository

import com.management.pet.repository.DataSource
import com.management.pet.repository.entity.PetProfile
import com.management.pet.repository.entity.Schedule

interface ScheduleDataSource: DataSource<MutableList<Schedule>>