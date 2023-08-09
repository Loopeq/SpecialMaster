package com.example.potolki.presentation.other

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potolki.common.Resource
import com.example.potolki.domain.use_case.region_use_case.GetAllRegionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CitySettingsScreenViewModel @Inject constructor(
    private val getAllRegionsUseCase: GetAllRegionsUseCase
): ViewModel()
{
    private val _state = mutableStateOf<CitySettingsState>(CitySettingsState())
    val state: State<CitySettingsState> = _state

    init{
        getAllRegions()
    }

    private fun getAllRegions(){
        getAllRegionsUseCase().onEach {
            result ->
            when(result){
                is Resource.Loading -> {
                    _state.value = CitySettingsState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CitySettingsState(regions = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CitySettingsState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }
}