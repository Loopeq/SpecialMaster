package com.example.potolki.data.remote

import androidx.compose.ui.res.stringResource
import com.example.potolki.R
import com.example.potolki.data.remote.model.client.MaterialCartDto
import com.example.potolki.data.remote.model.client.UserProfileDto
import com.example.potolki.data.remote.model.server.MaterialDto

object LocalUserProfileModel{
    val profile: UserProfileDto = UserProfileDto(
        image = R.drawable.fon,
        firstName = "Вася",
        lastName = "Рамштайнов",
        phone = "+79203744459",
        email = "arsen.00z11@gmail.com",
        region = "Ярославль"
    )
}

object LocalRegionModel{
    val regions = mutableListOf<String>(
        "Ярославль",
        "Гаврилов-Ям",
        "Мышкин",
        "Углич",
        "Рыбинск"
    )
}


object LocalMaterialCartModel{
    val listOfMaterialCart = mutableListOf<MaterialCartDto>(
    )
}

object LocalMaterialFavouriteModel{
    val listOfFavourite = mutableListOf<MaterialDto>(

    )
}

object LocalMaterialVarietiesModel{
    const val defaultImage = R.drawable.fon
    val listOfMaterialVarieties = mutableListOf<MaterialDto>(

    )
}

