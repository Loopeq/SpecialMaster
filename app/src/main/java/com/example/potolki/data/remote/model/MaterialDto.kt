package com.example.potolki.data.remote.model

import com.example.potolki.domain.model.Material

data class MaterialDto(
    val id: Int,
    val title: String,
    val imageSrc: String,
    val description: String,
    val price: String
)


fun MaterialDto.toMaterial(): Material{
    return Material(
        id = id,
        title = title,
        imageSrc = imageSrc,
        description = description,
        price = price
    )
}
