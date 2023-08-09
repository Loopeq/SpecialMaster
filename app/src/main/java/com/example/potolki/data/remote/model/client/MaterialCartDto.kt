package com.example.potolki.data.remote.model.client

import com.example.potolki.domain.model.MaterialCart

data class MaterialCartDto(
    val id: Int,
    val title: String,
    val parentId: Int,
    val price: Int,
    val imageSrc: Int,
    var count: Int = 1,
){
    var totalPrice: Int = count * price
}

fun MaterialCartDto.toMaterialCart(): MaterialCart {
    return MaterialCart(
        id = id,
        parentId = parentId,
        price = price,
        title = title,
        imageSrc = imageSrc,
        totalPrice = totalPrice,
        count = count
    )
}


