package com.example.potolki.presentation.favourite

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potolki.common.Resource
import com.example.potolki.domain.repository.MaterialRepository
import com.example.potolki.domain.use_case.favourite_use_case.GetFavouritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MaterialFavouriteScreenViewModel @Inject constructor(
    private val getFavourites: GetFavouritesUseCase
): ViewModel(){
    private val _state = mutableStateOf(MaterialFavouriteScreenState())
    val state: State<MaterialFavouriteScreenState> = _state

    init{
        getFavouritesToScreen()
    }

    private fun getFavouritesToScreen(){
        getFavourites().onEach { result->
            when(result){
                is Resource.Loading -> {
                    _state.value = MaterialFavouriteScreenState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = MaterialFavouriteScreenState(material = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MaterialFavouriteScreenState(error = result.message ?: "")

                }
            }
        }.launchIn(viewModelScope)
    }

}

