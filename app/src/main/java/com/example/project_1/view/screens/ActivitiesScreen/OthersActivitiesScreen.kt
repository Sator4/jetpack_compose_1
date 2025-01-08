package com.example.project_1.view.screens.ActivitiesScreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.project_1.view.screens.ActivitiesScreen.elements.ActivitiesScreen

@Composable
fun OthersActivitiesScreen(
    navController: NavController
){
    ActivitiesScreen(
        navController = navController,
        activitiesList = null,
        activitiesTab = 1
    )
}