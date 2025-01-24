package com.example.project_1.view.screens.ActivitiesScreen.elements

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project_1.Screen
import com.example.project_1.model.room.Activity
import com.example.project_1.ui.theme.BackgroundGray
import com.example.project_1.ui.theme.PrimaryBlue
import com.example.project_1.view.elements.BottomNavigation

@Composable
fun ActivitiesScreen(
    navController: NavController,
    activitiesList: List<Activity>?,
    activitiesTab: Int
){
//    val timeLong = ZonedDateTime.now().toInstant().toEpochMilli()
//    println(timeLong)
//    val timeInstant = Instant.ofEpochMilli(timeLong)
//    println(timeInstant)
//    val timeLocal = LocalDateTime.ofInstant(timeInstant, ZoneId.systemDefault())
//    println(timeLocal)
//    val timeDate = timeLocal.toLocalDate().toString()
//    val timeTime = timeLocal.toLocalTime().toString()
//    println((1234 - 125).milliseconds)
    Scaffold(
        containerColor = BackgroundGray,
        topBar = {
            ActivitiesTopNavigation(
                navController = navController,
                currentTab = activitiesTab
            )
        },
        bottomBar = {
            BottomNavigation(
                navController = navController,
                currentTab = 0
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .size(64.dp),
                shape = CircleShape,
                containerColor = PrimaryBlue,
                contentColor = Color.White,
                onClick = { navController.navigate(Screen.NewActivityScreenRoute.route) }
            ) {
                Icon(Icons.Default.PlayArrow, contentDescription = "")
            }
        }
    ){ padding ->
        if (activitiesList.isNullOrEmpty()) {
            if (activitiesTab == 0){
                EmptyPlaceholder(
                    placeholderHeadline = "Время потренить",
                    placeholderText = "Нажимай на кнопку ниже и начинаем трекать активность"
                )
            }
            else {
                EmptyPlaceholder(
                    placeholderHeadline = "Активности других людей нет",
                    placeholderText = "Признаков разумной жизни не обнаружено"
                )
            }
        }
        else {
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                items(activitiesList.toList()) { card ->
                    ActivityCard(
                        activity = card,
                        onClick = {
                            navController.navigate(
                                Screen.ActivityDetailsScreenRoute.route + "/${card.id}"
                            )
                        }
                    )
                }
            }
        }
    }
}


