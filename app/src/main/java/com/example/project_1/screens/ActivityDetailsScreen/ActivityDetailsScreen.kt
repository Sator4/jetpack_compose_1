package com.example.project_1.screens.ActivityDetailsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project_1.MyActivitiesScreenRoute
import com.example.project_1.OthersActivitiesScreenRoute
import com.example.project_1.screens.ActivitiesScreen.elements.ActivityClass
import com.example.project_1.screens.elements.BottomNavigation
import com.example.project_1.screens.elements.FormField
import com.example.project_1.screens.elements.TopBar
import com.example.project_1.ui.theme.TextDarkPrimary
import com.example.project_1.ui.theme.TextDarkSecondary
import com.example.project_1.ui.theme.W400_16_24
import com.example.project_1.ui.theme.W700_24_35

@Composable
fun ActivityDetailsScreen(
    navController: NavController,
    activity: ActivityClass = ActivityClass(
        distance = "14874 m",
        time = "2 h 14 m 43 s",
        activity = "Бег",
        date = "03.12.24",
        start_time = "12:24",
        finish_time = "14:38",
        comment = "You know, how fast I am? I'm fast as fck, boy"
    )
){
    Column {
        TopBar(
            navigate = { if(activity.usertag == null) navController.navigate(MyActivitiesScreenRoute) else navController.navigate(OthersActivitiesScreenRoute) },
            header = activity.activity,
            myActivityDetails = true,
            myActivityActions = arrayOf({ }, { })
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
                W700_24_35(activity.distance, TextDarkPrimary)
                W400_16_24(activity.date, TextDarkSecondary)
            }
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                W700_24_35(activity.activity, TextDarkPrimary)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    W400_16_24("Старт", TextDarkPrimary)
                    W400_16_24(activity.start_time, TextDarkSecondary)
                    Spacer(modifier = Modifier.width(0.dp))
                    W400_16_24("|", TextDarkSecondary)
                    Spacer(modifier = Modifier.width(0.dp))
                    W400_16_24("Финиш", TextDarkPrimary)
                    W400_16_24(activity.finish_time, TextDarkSecondary)
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