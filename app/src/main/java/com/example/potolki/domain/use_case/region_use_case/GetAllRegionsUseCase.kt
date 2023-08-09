package com.example.potolki.domain.use_case.region_use_case

import android.util.Log
import com.example.potolki.common.Resource
import com.example.potolki.domain.repository.MaterialRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllRegionsUseCase @Inject constructor(
    private val repository: MaterialRepository
){
    operator fun invoke(): Flow<Resource<List<String>>> = flow{
        try{
            emit(Resource.Loading<List<String>>())
            val regions = repository.getAllRegions()
            emit(Resource.Success<List<String>>(regions))
        }catch (e: Exception){
            Log.d("logi", "error in GetAllRegionsUseCase $e")
        }
    }
}