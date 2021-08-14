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
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainScope().launch(Dispatchers.IO){
            val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database.db").build()
            val profile = PetProfile( "미야옹철")

            db.petProfileDAO().save(profile);
            Log.d("debuging", db.petProfileDAO().getAll().toString())
        }

        setContent {
            PetManagementApp()
        }
    }

}