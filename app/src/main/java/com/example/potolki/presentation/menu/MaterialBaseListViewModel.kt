package com.example.potolki.presentation.menu

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potolki.common.Resource
import com.example.potolki.domain.use_case.get_materials.GetMaterialsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel()
class MaterialBaseListViewModel @Inject constructor(
    private val getMaterialsUseCase: GetMaterialsUseCase
): ViewModel() {

    private val _state = mutableStateOf(MaterialBaseListState())
    val state: State<MaterialBaseListState> = _state

    init{
        getMaterials()
    }

    private fun getMaterials(){
        getMaterialsUseCase().onEach{ result ->
            when(result){
                is Resource.Success ->
                    _state.value = MaterialBaseListState(material = result.data ?: emptyList())

                is Resource.Loading ->
                    _state.value = MaterialBaseListState(isLoading = true)

                is Resource.Error ->
                    _state.value = MaterialBaseListState(error = result.message ?: "")
            }
        }.launchIn(viewModelScope)

    }
}