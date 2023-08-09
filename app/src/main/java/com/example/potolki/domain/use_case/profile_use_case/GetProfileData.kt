package com.example.potolki.domain.use_case.profile_use_case

import android.util.Log
import com.example.potolki.common.Resource
import com.example.potolki.data.remote.model.client.toUserProfile
import com.example.potolki.domain.model.UserProfile
import com.example.potolki.domain.repository.MaterialRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProfileData @Inject constructor(
    private val repository: MaterialRepository
){
    operator fun invoke(): Flow<Resource<UserProfile>> = flow{
        try{
            emit(Resource.Loading<UserProfile>())
            val user = repository.getProfileData().toUserProfile()
            emit(Resource.Success<UserProfile>(user))

        } catch (e: java.lang.Exception){
            Log.d("logi", "ex in GetProfileDta $e")

        }
    }
}