package com.management.pet.profiles

data class PetProfile(
    val name: String,
    var uid: Int = 0
) {
    override fun equals(other: Any?): Boolean {
        if (other is PetProfile) {
            return other.uid == uid
        }
        return false
    }

    override fun hashCode(): Int {
        return uid
    }
}