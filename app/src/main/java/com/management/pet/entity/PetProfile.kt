package com.management.pet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PetProfile(
    @PrimaryKey
    val uid: Int,
    // status
    val name: String,
    val sex: Sex,
    val age: Int,
    val type: String, // 개, 고양이
    val breed: String, // 종
    // taste
    val habit: String,
    // eating habit
    val favoriteFood: String,
    val hateFood: String,
    val allergyFood: String,
    // health
    val disease: String,
    val medicalHistory: String, // 앱 사용 전 기록과 앱 사용 후 치료기록을 어떻게 다룰 것인가?
) {
//    fun setName(name: String): PetProfile {
//        return PetProfile(name)
//    }
}

enum class Sex {
    Male, Female
}