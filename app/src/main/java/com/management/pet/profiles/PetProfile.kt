package com.management.pet.profiles

data class PetProfile(
    val name: String,
    var uid: Int = 0
) {
    fun assign(change: PetProfileChange): PetProfile {
        return PetProfile(change.name ?: name, uid=uid)
    }
}