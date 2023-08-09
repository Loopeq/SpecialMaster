package com.example.potolki.presentation.favourite

import com.example.potolki.domain.model.Material
import com.example.potolki.domain.model.MaterialCart

data class MaterialFavouriteScreenState(
    val isLoading: Boolean = false,
    val material: List<Material> = emptyList(),
    val error: String = ""
)