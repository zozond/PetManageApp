package com.management.pet.repository

import com.management.pet.repository.DataSource
import com.management.pet.repository.entity.PetProfile

interface PetProfileDataSource: DataSource<MutableList<PetProfile>>