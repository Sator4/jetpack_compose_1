package com.example.project_1.view.screens.ActivitiesScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.asLiveData
import androidx.navigation.NavController
import com.example.project_1.Screen
import com.example.project_1.model.room.Activity
import com.example.project_1.view.screens.ActivitiesScreen.elements.ActivitiesScreen
import com.example.project_1.viewmodel.ActivitiesViewModel

@Composable
fun MyActivitiesScreen(
    navController: NavController,
    activitiesViewModel: ActivitiesViewModel = hiltViewModel()
){
    val activitiesList = activitiesViewModel.activities().asLiveData()

    ActivitiesScreen(
        navController = navController,
        activitiesTab = 0,
        activitiesList = activitiesList.observeAsState().value
    )
}