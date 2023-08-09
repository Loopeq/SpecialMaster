package com.example.potolki.domain.use_case.varieties_use_case.add_item_to_cart

import android.util.Log
import com.example.potolki.domain.repository.MaterialRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CheckItemInCart @Inject constructor(
    private val repository: MaterialRepository
) {

    operator fun invoke(parentId: Int, id: Int): Flow<Boolean> = flow{
        try{
            val result = repository.checkVarietiesInCart(id = id, parentId = parentId)
            emit(result)
        } catch(e: Exception){
            Log.d("Logi", e.toString())
        }
    }
}