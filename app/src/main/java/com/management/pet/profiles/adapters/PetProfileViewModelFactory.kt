package com.management.pet.profiles.adapters

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.management.pet.AppDatabase
import com.management.pet.profiles.PetProfileRepository

class PetProfileViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(PetProfileLiveDataViewModel::class.java) -> {
                val db = AppDatabase.getDatabase(context)
                val petProfileRepository: PetProfileRepository = PetProfileRoomRepository(db.petProfileDAO())

                PetProfileLiveDataViewModel(petProfileRepository) as T
            }
            else -> {
                throw IllegalArgumentException()
            }
        }
    }
}