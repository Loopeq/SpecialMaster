package com.example.potolki.data.remote.model.client

import com.example.potolki.domain.model.UserProfile

data class UserProfileDto(
    var image: Int,
    var firstName: String,
    var lastName: String,
    var phone: String,
    var email: String,
    var region: String,
)

fun UserProfileDto.toUserProfile(): UserProfile {
    return UserProfile(
        image = image,
        phone = phone,
        email = email,
        firstName = firstName,
        lastName = lastName,
        region = region
    )
}


