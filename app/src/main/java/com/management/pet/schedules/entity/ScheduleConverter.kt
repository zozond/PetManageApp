package com.management.pet.schedules.entity

import androidx.room.TypeConverter
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ScheduleConverter {
    @TypeConverter
    fun fromLocalDate(date: LocalDateTime?): String? {
        return date?.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    }

    @TypeConverter
    fun localDateFromString(dateString: String?): LocalDateTime? {
        return dateString?.let{ LocalDateTime.parse(it, DateTimeFormatter.ISO_LOCAL_DATE_TIME) }
    }

    @TypeConverter
    fun fromDuration(duration: Duration?): Long? {
        return duration?.toMillis()
    }

    @TypeConverter
    fun durationFromLong(duration: Long?): Duration? {
        return duration?.let { Duration.ofMillis(it) }
    }
}