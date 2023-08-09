package com.example.potolki.domain.use_case.varieties_use_case.get_varieties

import android.util.Log
import com.example.potolki.common.Resource
import com.example.potolki.data.remote.model.server.toMaterial
import com.example.potolki.domain.model.Material
import com.example.potolki.domain.repository.MaterialRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetVarietiesUseCase @Inject constructor(
    private val repository: MaterialRepository
) {
    operator fun invoke(parentId: Int): Flow<Resource<List<Material>>> = flow{
        try{
            emit(Resource.Loading<List<Material>>())
            val varieties = repository.getVarieties(parentId).map{it.toMaterial()}
            emit(Resource.Success<List<Material>>(varieties))
        } catch(e: java.lang.Exception){
            Log.d("Logi", "error in get varieties use case $e")
        }
    }
}