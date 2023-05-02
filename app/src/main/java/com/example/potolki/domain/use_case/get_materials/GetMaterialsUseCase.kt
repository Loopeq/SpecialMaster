package com.example.potolki.domain.use_case.get_materials

import android.util.Log
import com.example.potolki.common.Resource
import com.example.potolki.data.remote.model.toMaterial
import com.example.potolki.domain.model.Materials
import com.example.potolki.domain.repository.MaterialRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMaterialsUseCase @Inject constructor(
    private val repository: MaterialRepository
) {
    operator fun invoke(): Flow<Resource<List<Materials>>> = flow{
        try{
            emit(Resource.Loading<List<Materials>>())
            val materials = repository.getMaterials().map{ it.toMaterial()}
            emit(Resource.Success<List<Materials>>(materials))
        } catch(e: java.lang.Exception){
            Log.d("Logi", "error in get materials use case $e")
        }
    }
}