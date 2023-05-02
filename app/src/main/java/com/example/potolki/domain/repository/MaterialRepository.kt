package com.example.potolki.domain.repository

import com.example.potolki.data.remote.model.MaterialDto
import com.example.potolki.data.remote.model.MaterialsDto

interface MaterialRepository {

    suspend fun getMaterials(): List<MaterialsDto>
    suspend fun getMaterialById(itemId: String): MaterialDto

}