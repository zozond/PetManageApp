package com.management.pet.profiles.adapters

import com.management.pet.profiles.PetProfile
import com.management.pet.profiles.PetProfileChange
import com.management.pet.profiles.PetProfileRepository
import com.management.pet.profiles.entity.PetProfileEntity
import com.management.pet.profiles.entity.PetProfileEntityDAO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PetProfileRoomRepository(private val dao: PetProfileEntityDAO): PetProfileRepository {
    override fun readAll(): Flow<List<PetProfile>> {
        return dao.getAll().map { list -> list.map { it.toPetProfile() } }
    }

    override fun add(profile: PetProfile) {
        dao.insert(profile.toEntity())
    }

    override fun update(profile: PetProfile, change: PetProfileChange) {
        dao.update(profile.assign(change).toEntity())
    }

    override fun remove(profile: PetProfile) {
        dao.delete(profile.toEntity())
    }

    private fun PetProfile.assign(change: PetProfileChange): PetProfile {
        return PetProfile(change.name ?: name, uid=uid)
    }

    private fun PetProfileEntity.toPetProfile(): PetProfile {
        return PetProfile(name, uid)
    }

    private fun PetProfile.toEntity(): PetProfileEntity {
        return PetProfileEntity(name, uid)
    }
}