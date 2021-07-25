package com.management.pet

object MemoryPetProfileDataSource: PetProfileDataSource {
    private val pets = mutableListOf<PetProfile>()
    private var petListener: DataSourceListener<MutableList<PetProfile>>? = null

    override fun observe(listener: DataSourceListener<MutableList<PetProfile>>) {
        petListener = listener
    }

    override fun update(block: MutableList<PetProfile>.() -> Unit) {
        pets.block()
        notifyChanged()
    }

    private fun notifyChanged() {
        petListener?.invoke(pets)
    }

    override val value: MutableList<PetProfile>
        get() = pets
}