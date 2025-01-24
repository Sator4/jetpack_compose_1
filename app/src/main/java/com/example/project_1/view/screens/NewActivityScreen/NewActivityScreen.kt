package com.example.project_1.view.screens.NewActivityScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.project_1.R
import com.example.project_1.Screen
import com.example.project_1.viewmodel.ActivitiesViewModel

@Composable
fun NewActivityScreen(
    navController: NavController,
    activitiesViewModel: ActivitiesViewModel = hiltViewModel()
){
    var state by remember { mutableStateOf(0) }
    var activityName by remember { mutableStateOf("") }
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        if (state == 0) navController.navigate(Screen.MyActivitiesScreenRoute.route)
                        else state = 0
                    },
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "back_arrow",
            )
            if (state == 0){
                SelectActivity(
                    changeState =  { newState -> if (activityName != "") state = newState },
                    selectActivity = { newActivity -> activityName = newActivity },
                    activityName = activityName
                )
            }
            else {
                RunningActivity(
                    finishActivity = { activity ->
                        activitiesViewModel.addActivity(activity)
                        navController.navigate(Screen.MyActivitiesScreenRoute.route)
                    },
                    activityName = activityName
                )
            }
        }

    }
}



