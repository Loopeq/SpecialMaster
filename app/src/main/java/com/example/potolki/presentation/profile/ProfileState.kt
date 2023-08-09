package com.example.potolki.presentation.profile

import com.example.potolki.R
import com.example.potolki.domain.model.Material
import com.example.potolki.domain.model.UserProfile

data class ProfileState(
    val isLoading: Boolean = false,
    val material: UserProfile = UserProfile(
        image = R.drawable.fon,
        phone = "+76665554433",
        email = "gmail@gmail.com",
        firstName = "Пользователь",
        lastName = "Магазина",
        region = "Ярославль"
    ),
    val error: String = ""
)
