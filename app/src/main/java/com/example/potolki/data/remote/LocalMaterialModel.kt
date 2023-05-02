package com.example.potolki.data.remote

import com.example.potolki.data.remote.model.MaterialsDto

object LocalMaterialModel {
    val listOfMaterial = listOf<MaterialsDto>(
        MaterialsDto(
            id = 0,
            title = "Инструменты",
            imageSrc = "https://s.nooirf.ru/wp-content/uploads/2021/08/no_image.jpg"
        ),

        MaterialsDto(
            id = 1,
            title = "Расходники",
            imageSrc = "https://s.nooirf.ru/wp-content/uploads/2021/08/no_image.jpg"
        ),
        MaterialsDto(
            id = 2,
            title = "Потолки",
            imageSrc = "https://s.nooirf.ru/wp-content/uploads/2021/08/no_image.jpg"
        ),
        MaterialsDto(
            id = 3,
            title = "Вставка",
            imageSrc = "https://s.nooirf.ru/wp-content/uploads/2021/08/no_image.jpg"
        ),
        MaterialsDto(
            id = 4,
            title = "Брус",
            imageSrc = "https://s.nooirf.ru/wp-content/uploads/2021/08/no_image.jpg"
        ),
        MaterialsDto(
            id = 5,
            title = "Уголки",
            imageSrc = "https://s.nooirf.ru/wp-content/uploads/2021/08/no_image.jpg"
        )
    )

}