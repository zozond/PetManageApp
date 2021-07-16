package com.management.pet

object MemoryPetDataSource: PetDataSource {
    private val pets = mutableListOf<String>()
    private var petListener: DataSourceListener<MutableList<String>>? = null

    override fun observe(listener: DataSourceListener<MutableList<String>>) {
        petListener = listener
    }

    override fun update(block: MutableList<String>.() -> Unit) {
        pets.block()
        notifyChanged()
    }

    private fun notifyChanged() {
        petListener?.invoke(pets)
    }

    override val value: MutableList<String>
        get() = pets
}