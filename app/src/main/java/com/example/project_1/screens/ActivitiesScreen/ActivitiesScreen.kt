package com.example.project_1.screens.ActivitiesScreen

import androidx.compose.foundation.layout.Arrangement
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
import com.example.project_1.NewActivityScreenRoute
import com.example.project_1.screens.elements.ActivityCard
import com.example.project_1.screens.elements.ActivityClass
import com.example.project_1.screens.elements.EmptyPlaceholder
import com.example.project_1.ui.theme.BackgroundGray
import com.example.project_1.ui.theme.PrimaryBlue

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ActivitiesScreen(
    navController: NavController,
    activitiesList: MutableList<ActivityClass>,
    activitiesTab: Int
){
    Scaffold(
        containerColor = BackgroundGray,
        topBar = {
            ActivitiesHeader(
                navController = navController,
                currentTab = activitiesTab
            )
        },
        bottomBar = {
            ActivitiesFooter(
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
                onClick = { navController.navigate(NewActivityScreenRoute) }
            ) {
                Icon(Icons.Default.PlayArrow, contentDescription = "")
            }
        }
    ){ padding ->
        if (activitiesList.isEmpty()) {
            EmptyPlaceholder()
        }
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(activitiesList.toList()) { card ->
                ActivityCard(navController, card)
            }
        }
    }
}


