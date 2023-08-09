package com.example.potolki.domain.model

data class UserProfile(
    val image: Int,
    val phone: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val region: String
){
    val fullName: String = "$firstName $lastName"
}
