package com.example.potolki.presentation.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.getSelectedText
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potolki.common.Resource
import com.example.potolki.domain.use_case.profile_use_case.GetProfileData
import com.example.potolki.domain.use_case.profile_use_case.UpdateEmailUseCase
import com.example.potolki.domain.use_case.profile_use_case.UpdatePhoneUseCase
import com.example.potolki.presentation.favourite.MaterialFavouriteScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(
    private val getProfileData: GetProfileData,
    private val updateEmailUseCase: UpdateEmailUseCase,
    private val updatePhoneUseCase: UpdatePhoneUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(ProfileState())
    val state: State<ProfileState> = _state

    var textFieldValue by mutableStateOf("")

    fun editText(text: String){
        textFieldValue = text
    }

    var dialogIsShow by mutableStateOf(false)
        private set

    fun onExchangeClick(){
        dialogIsShow = true
    }

    fun onCancelClick(){
        dialogIsShow = false
    }

    
    init {
        getProfileInfo()
    }

    private fun getProfileInfo() {
        getProfileData().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = ProfileState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ProfileState(material = result.data!!)
                }
                is Resource.Error -> {
                    _state.value = ProfileState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun updatePhone(newPhone: String) {
        updatePhoneUseCase(newPhone).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = ProfileState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ProfileState(material = result.data!!)
                }
                is Resource.Error -> {
                    _state.value = ProfileState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }

}