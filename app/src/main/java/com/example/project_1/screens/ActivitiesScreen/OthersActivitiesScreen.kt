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
            distance = "2341 m",
            time = "34 m 10 s",
            activity = "Ходьба",
            date = "01.12.24",
            usertag = "@sator_rotas"
        )
    )
    ActivitiesScreen(
        navController = navController,
        activitiesList = activitiesList,
        activitiesTab = 1
    )
}