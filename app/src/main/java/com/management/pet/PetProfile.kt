package com.management.pet

data class PetProfile(
    val name: String
) {
    fun setName(name: String): PetProfile {
        return PetProfile(name)
    }
}
