package com.example.potolki.domain.use_case.varieties_use_case.get_varieties_description

import android.util.Log
import com.example.potolki.common.Resource
import com.example.potolki.data.remote.model.server.toMaterial
import com.example.potolki.domain.model.Material
import com.example.potolki.domain.repository.MaterialRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetVarietiesDescriptionUseCase @Inject constructor(
    private val repository: MaterialRepository
) {
    operator fun invoke(parentId: Int, id: Int): Flow<Resource<Material>> = flow{
        try{
            emit(Resource.Loading<Material>())
            val varieties = repository.getVarietiesDescription(id = id, parentId = parentId).toMaterial()
            emit(Resource.Success<Material>(varieties))
        } catch(e: Exception){
            Log.d("Logi", "error in get varieties use case $e")
        }
    }

}