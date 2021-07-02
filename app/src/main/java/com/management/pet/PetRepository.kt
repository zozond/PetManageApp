package com.management.pet

interface PetRepository {
    fun add(pet: String)
    fun readAll() : List<String>
}

class PetSharedPreference : PetRepository {
    override fun add(pet: String) {
        TODO("Not yet implemented")
    }

    override fun readAll(): List<String> {
        TODO("Not yet implemented")
    }
}
