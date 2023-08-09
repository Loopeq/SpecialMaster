package com.example.potolki.domain.use_case.varieties_use_case.add_item_to_favourite

import android.util.Log
import com.example.potolki.common.Resource
import com.example.potolki.data.remote.model.server.toMaterial
import com.example.potolki.domain.model.Material
import com.example.potolki.domain.repository.MaterialRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddItemToFavouriteUseCase @Inject constructor(
    private val repository: MaterialRepository
) {
    operator fun invoke(parentId: Int, id: Int): Flow<Resource<List<Material>>> = flow{
     try{
         emit(Resource.Loading<List<Material>>())
         val varieties = repository.addVarietiesToFavourite(parentId = parentId, id = id).toMaterial()
         emit(Resource.Success<List<Material>>(listOf(varieties)))
     } catch(e: java.lang.Exception){
          Log.d("logi", "message $e")
     }
    }
}