package com.example.potolki.data.repository

import com.example.potolki.data.remote.LocalMaterialModel
import com.example.potolki.data.remote.model.MaterialDto
import com.example.potolki.data.remote.model.MaterialsDto
import com.example.potolki.domain.repository.MaterialRepository

class MaterialRepositoryImpl: MaterialRepository {

    override suspend fun getMaterials(): List<MaterialsDto> {
        return LocalMaterialModel.listOfMaterial
    }

    override suspend fun getMaterialById(itemId: String): MaterialDto {
        TODO("Local material by id suspend")
    }
}