package com.management.pet.repository

import com.management.pet.schedules.Schedule

interface ScheduleDataSource: DataSource<MutableList<Schedule>>