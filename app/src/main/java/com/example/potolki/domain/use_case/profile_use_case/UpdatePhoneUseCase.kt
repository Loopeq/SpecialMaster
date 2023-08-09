package com.example.potolki.domain.use_case.profile_use_case

import android.util.Log
import com.example.potolki.common.Resource
import com.example.potolki.data.remote.model.client.toUserProfile
import com.example.potolki.domain.model.UserProfile
import com.example.potolki.domain.repository.MaterialRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class UpdatePhoneUseCase @Inject constructor(
    private val repository: MaterialRepository
) {
    operator fun invoke(newPhone: String): Flow<Resource<UserProfile>> = flow{
        try{
            emit(Resource.Loading<UserProfile>())
            val user = repository.updatePhone(newPhoneNumber = newPhone).toUserProfile()
            emit(Resource.Success<UserProfile>(user))
        } catch (e: Exception){
            Log.d("logi", "error in Update Email Use Case $e")
        }
    }
}