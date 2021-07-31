package com.management.pet

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.management.pet.repository.AppDatabase
import com.management.pet.repository.entity.PetProfile
import com.management.pet.repository.entity.Sex
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        launch(Dispatchers.IO) {
            val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database.db")
                .build()

            val profile = PetProfile(2, "강아지 강2", Sex.Male,
                1,"","","","","",
                "","","")

            db.petProfileDAO().save(profile);
            Log.d("debuginginginging", db.petProfileDAO().getAll().toString())
        }

        setContent {
            PetManagementApp()
        }
    }

    private fun launch(io: CoroutineDispatcher, function: () -> Unit) {

    }
}