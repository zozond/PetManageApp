package com.management.pet.repository.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PetProfile(
        val name: String,
//        val sex: Sex,
//        val age: Int ,
//        val type: String, // 개, 고양이
//        val breed: String , // 종
//        // taste
//        val habit: String ,
//        // eating habit
//        val favoriteFood: String ,
//        val hateFood: String,
//        val allergyFood: String ,
//        // health
//        val disease: String,
//        val medicalHistory: String, // 앱 사용 전 기록과 앱 사용 후 치료기록을 어떻게 다룰 것인가?
) {
        @PrimaryKey(autoGenerate = true)
        var uid: Int = 0
}

enum class Sex {
        Male, Female
}