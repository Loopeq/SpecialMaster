package com.example.potolki.domain.use_case.varieties_use_case.add_item_to_favourite

import android.util.Log
import com.example.potolki.common.Resource
import com.example.potolki.data.remote.model.client.toMaterialCart
import com.example.potolki.data.remote.model.server.toMaterial
import com.example.potolki.domain.model.Material
import com.example.potolki.domain.model.MaterialCart
import com.example.potolki.domain.repository.MaterialRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class RemoveItemFromFavourite @Inject constructor(
    private val repository: MaterialRepository
) {
    operator fun invoke(id: Int, parentId: Int): Flow<Resource<List<Material>>> = flow {
        try{
            emit(Resource.Loading<List<Material>>())
            val varieties = repository.deleteVarietiesFromFavourite(id = id, parentId = parentId).map{it.toMaterial()}
            emit(Resource.Success<List<Material>>(varieties))
        } catch(e: Exception){
            Log.d("Logi", "error in get varieties use case $e")
        }
    }
}