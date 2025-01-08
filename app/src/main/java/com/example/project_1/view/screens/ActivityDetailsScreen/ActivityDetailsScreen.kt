package com.example.project_1.view.screens.ActivityDetailsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.asLiveData
import androidx.navigation.NavController
import com.example.project_1.Screen
import com.example.project_1.ui.theme.BigFont
import com.example.project_1.ui.theme.RegularFont
import com.example.project_1.ui.theme.TextDarkSecondary
import com.example.project_1.view.elements.BottomNavigation
import com.example.project_1.view.elements.FormField
import com.example.project_1.view.elements.TopBar
import com.example.project_1.viewmodel.ActivitiesViewModel

@Composable
fun ActivityDetailsScreen(
    navController: NavController,
    activityId: Int,
    activitiesViewModel: ActivitiesViewModel = hiltViewModel()
){
    var confirmDeleteWindow by remember { mutableStateOf(false) }
    val activity = activitiesViewModel.getActivity(activityId).asLiveData().observeAsState().value
    if (activity != null){
        Box {
            if (confirmDeleteWindow){
                ConfirmDelete(
                    onClickYes = {
                        activitiesViewModel.deleteActivity(activity)
                        navController.navigate(Screen.MyActivitiesScreenRoute.route)
                    },
                    onClickNo = { confirmDeleteWindow = false }
                )
            }
            Column {
                TopBar(
                    navigate = {
                        if(activity.usertag == "")
                            navController.navigate(Screen.MyActivitiesScreenRoute.route)
                        else
                            navController.navigate(Screen.OthersActivitiesScreenRoute.route)
                    },
                    header = activity.activityType,
                    myActivityDetails = true,
                    myActivityActions = arrayOf(
                        {
                            confirmDeleteWindow = true

                        },
                        { }
                    )
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(vertical = 24.dp, horizontal = 32.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        BigFont(activity.distance.toString())
                        RegularFont(activity.startTime.toString(), color = TextDarkSecondary)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        BigFont(activity.activityType)
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            RegularFont("Старт")
                            RegularFont(activity.startTime.toString(), color = TextDarkSecondary)
                            Spacer(modifier = Modifier.width(0.dp))
                            RegularFont("|", color = TextDarkSecondary)
                            Spacer(modifier = Modifier.width(0.dp))
                            RegularFont("Финиш")
                            RegularFont(activity.finishTime.toString(), color = TextDarkSecondary)
                        }
                    }
                    var comment by remember { mutableStateOf("") }
                    FormField(text = comment, "Комментарий", onTextChange = { comment = it })
                }
                BottomNavigation(
                    navController = navController,
                    currentTab = 0
                )
            }
        }
    }
}