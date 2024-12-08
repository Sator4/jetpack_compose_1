package com.example.project_1.screens.ActivitiesScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.project_1.screens.elements.ActivityClass

@Composable
fun MyActivities(
    navController: NavController
){
    val activitiesList = remember { mutableListOf<ActivityClass>() }
    activitiesList.add(
        ActivityClass(
            distance = "14874 m",
            time = "2 h 14 m 43 s",
            activity = "Running",
            date = "03.12.24"
        )
    )
    ActivitiesScreen(
        navController = navController,
        activitiesList = activitiesList,
        activitiesTab = 0
    )
}