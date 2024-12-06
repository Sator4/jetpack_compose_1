package com.example.project_1.screens.ActivitiesScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.project_1.screens.elements.ActivityClass

@Composable
fun OthersActivities(
    navController: NavController
){
    val activitiesList = remember { mutableListOf<ActivityClass>() }
    activitiesList.add(
        ActivityClass(
            distance = "9874 m",
            time = "2 h 14 m 43 s",
            activity = "Running",
            date = "03.12.24",
            usertag = "@sator_rotas"
        )
    )
    ActivitiesScreen(
        navController = navController,
        activitiesList = activitiesList,
        activitiesTab = 1
    )
}