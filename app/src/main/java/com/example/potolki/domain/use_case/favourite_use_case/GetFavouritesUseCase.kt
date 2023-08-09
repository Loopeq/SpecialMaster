package com.example.potolki.domain.use_case.favourite_use_case

import android.util.Log
import com.example.potolki.common.Resource
import com.example.potolki.data.remote.model.server.toMaterial
import com.example.potolki.domain.model.Material
import com.example.potolki.domain.repository.MaterialRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFavouritesUseCase @Inject constructor(
    private val repository: MaterialRepository
) {
    operator fun invoke(): Flow<Resource<List<Material>>> = flow{
        try{
            emit(Resource.Loading<List<Material>>())
            delay(1000)
            val favourites = repository.getFavourite().map{ it.toMaterial() }
            emit(Resource.Success<List<Material>>(favourites))
        } catch(e: java.lang.Exception){
            Log.d("Logi", "error $e")
        }
    }
}