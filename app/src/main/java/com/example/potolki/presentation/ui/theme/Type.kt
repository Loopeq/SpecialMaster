package com.example.potolki.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.potolki.R


val Comfortaa = FontFamily(
    Font(R.font.comfortaa_regular, FontWeight.Normal),
    Font(R.font.comfortaa_bold, FontWeight.Bold),
    Font(R.font.comfortaa_light, FontWeight.Light),
    Font(R.font.comfortaa_medium, FontWeight.Medium),
    Font(R.font.comfortaa_semi_bold, FontWeight.SemiBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = Comfortaa,
    //for materials
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    //for search bar
    h2 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    // for cart item name
    h3 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    // for cart item price
    h4 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 16.sp
    ),
    // for cart item description
    h5 = TextStyle(
        fontWeight = FontWeight.Thin,
        fontSize = 16.sp
    )


)