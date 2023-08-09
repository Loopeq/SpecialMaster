package com.example.potolki.presentation.other


data class CitySettingsState(
    val isLoading: Boolean = false,
    val regions: List<String> = emptyList(),
    val error: String = ""
)