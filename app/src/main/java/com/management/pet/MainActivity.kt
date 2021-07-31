package com.management.pet

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.management.pet.entity.PetProfile
import com.management.pet.entity.Sex

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database.db"
        ).build()
        val profile = PetProfile(1, "개..", Sex.Male,
        1,"","","","","",
        "","","")
        db.petProfileDao().save(profile)

        setContent {
            PetManagementApp()
        }
    }
}