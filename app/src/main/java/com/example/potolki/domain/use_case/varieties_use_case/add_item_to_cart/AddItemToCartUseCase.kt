package com.example.potolki.domain.use_case.varieties_use_case.add_item_to_cart

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

class AddItemToCartUseCase @Inject constructor(
    private val repository: MaterialRepository
) {
    operator fun invoke(parentId: Int, id: Int): Flow<Resource<List<MaterialCart>>> = flow {
        try{
            emit(Resource.Loading<List<MaterialCart>>())
            val varieties = repository.addVarietiesToCart(parentId = parentId, id = id).toMaterialCart()
            emit(Resource.Success<List<MaterialCart>>(listOf(varieties)))
        } catch(e: Exception){
            Log.d("Logi", "error in get varieties use case $e")
        }
    }
}