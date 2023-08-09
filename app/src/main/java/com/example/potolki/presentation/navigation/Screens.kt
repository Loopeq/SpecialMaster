package com.example.potolki.presentation.navigation

sealed class Screens(
    val route: String
) {

    object ProductViewOrContent: Screens(
        route = "product_view_or_content_screen"
    )

    object ProductContentViewScreen: Screens(
        route = "product_content_view_screen"
    )

    object VarietiesDescriptionScreen: Screens(
        route = "material_varieties_description_screen"
    )



    object CitySettingsScreen: Screens(
        route = "city_settings_screen"
    )

}

