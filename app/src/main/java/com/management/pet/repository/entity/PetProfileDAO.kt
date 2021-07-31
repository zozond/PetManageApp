package com.management.pet.repository.entity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PetProfileDAO {
    @Query("SELECT * FROM petProfile")
    fun getAll(): List<PetProfile>

    @Insert
    fun save(petProfile: PetProfile)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertUsers(vararg users: User)
//
//    @Insert
//    fun insertBothUsers(user1: User, user2: User)
//
//    @Insert
//    fun insertUsersAndFriends(user: User, friends: List<User>)
}
