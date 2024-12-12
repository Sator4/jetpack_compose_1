package com.example.project_1.screens.ActivitiesScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.project_1.screens.ActivitiesScreen.elements.ActivitiesScreen
import com.example.project_1.screens.ActivitiesScreen.elements.ActivityClass

@Composable
fun MyActivitiesScreen(
    navController: NavController
){
    val activitiesList = remember { mutableListOf(
        ActivityClass(
            distance = "14874 m",
            time = "2 h 14 m 43 s",
            activity = "Бег",
            date = "03.12.24"
        ),
        ActivityClass(
            distance = "14874 m",
            time = "2 h 14 m 43 s",
            activity = "Бег",
            date = "03.12.24"
        )
    ) }
    ActivitiesScreen(
        navController = navController,
        activitiesList = activitiesList,
        activitiesTab = 0
    )
}