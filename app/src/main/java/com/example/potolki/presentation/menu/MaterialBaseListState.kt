package com.example.potolki.presentation.menu

import com.example.potolki.domain.model.Materials

data class MaterialBaseListState(
    val isLoading: Boolean = false,
    val material: List<Materials> = emptyList(),
    val error: String = ""
)
