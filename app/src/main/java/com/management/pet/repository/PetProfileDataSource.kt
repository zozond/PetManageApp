package com.management.pet.repository

import com.management.pet.profiles.PetProfile

interface PetProfileDataSource: DataSource<MutableList<PetProfile>>