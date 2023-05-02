package com.example.potolki.data.remote.model

import com.example.potolki.domain.model.Materials

data class MaterialsDto(
    val id: Int,
    val title: String,
    val imageSrc: String,
)


fun MaterialsDto.toMaterial(): Materials{
    return Materials(
        id = id,
        title = title,
        imageSrc = imageSrc
    )
}
