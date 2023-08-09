package com.example.potolki.data.remote.model.client

import com.example.potolki.domain.model.MaterialOrders

data class MaterialOrdersDto(
    val id: Int,
    val order: Boolean = false,
    val title: String,
    val imageSrc: String,
    val count: Int,
    val price: Int
)

fun MaterialOrdersDto.toMaterialOrders(): MaterialOrders{
    return MaterialOrders(
        id = id,
        order = order,
        title = title,
        imageSrc = imageSrc,
        count = count,
        price = price
    )
}


