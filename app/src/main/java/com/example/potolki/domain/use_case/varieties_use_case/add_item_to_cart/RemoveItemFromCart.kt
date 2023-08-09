package com.example.potolki.domain.use_case.varieties_use_case.add_item_to_cart

import android.util.Log
import com.example.potolki.common.Resource
import com.example.potolki.data.remote.model.client.toMaterialCart
import com.example.potolki.domain.model.MaterialCart
import com.example.potolki.domain.repository.MaterialRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class RemoveItemFromCart @Inject constructor(
    private val repository: MaterialRepository
) {
    operator fun invoke(id: Int, parentId: Int): Flow<Resource<List<MaterialCart>>> = flow{
        try{
            emit(Resource.Loading<List<MaterialCart>>())
            val varieties = repository.deleteVarietiesFromCart(id = id, parentId = parentId).map{it.toMaterialCart()}
            emit(Resource.Success<List<MaterialCart>>(varieties))
        } catch(e: Exception){
            Log.d("Logi", "error in get varieties use case $e")
        }
    }
}