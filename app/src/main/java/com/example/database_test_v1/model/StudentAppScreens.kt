package com.example.database_test_v1.model

sealed class StudentAppScreens(val route:String) {
    object HomeScreen: StudentAppScreens("home_screen")
    object AddScreen: StudentAppScreens("add_screen")
}

