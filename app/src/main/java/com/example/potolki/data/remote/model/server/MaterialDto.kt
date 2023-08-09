package com.example.potolki.data.remote.model.server

import com.example.potolki.domain.model.Material

data class MaterialDto(
    val id: Int,
    val parentId: Int,
    val title: String,
    val amount: String,
    val unit: String,
    val imageSrc: Int,
    val description: String,
    val price: Int
)


fun MaterialDto.toMaterial(): Material{
    return Material(
        id = id,
        parentId = parentId,
        title = title,
        imageSrc = imageSrc,
        description = description,
        price = price,
        amount = amount,
        unit = unit,
    )
}
