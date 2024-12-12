package com.example.project_1.screens.ActivitiesScreen.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project_1.ActivityDetailsScreenRoute
import com.example.project_1.ui.theme.PrimaryBlue
import com.example.project_1.ui.theme.TextDarkPrimary
import com.example.project_1.ui.theme.TextDarkSecondary
import com.example.project_1.ui.theme.W400_16_24
import com.example.project_1.ui.theme.W700_24_35

@Composable
fun ActivityCard(
    navController: NavController,
    activity: ActivityClass
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .shadow(2.dp)
            .border(
                border = BorderStroke(0.dp, Color.Transparent),
                shape = RoundedCornerShape(4.dp)
            )
            .clickable { navController.navigate(ActivityDetailsScreenRoute) }
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                W700_24_35(activity.distance, TextDarkPrimary)
                if (activity.usertag != null){
                    W400_16_24(activity.usertag, PrimaryBlue, Modifier.clickable {  })
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            W400_16_24(activity.time, TextDarkPrimary)
            Spacer(modifier = Modifier.height(4.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                W400_16_24(activity.activity, TextDarkPrimary)
                W400_16_24(activity.date, TextDarkSecondary)
            }
        }
    }
}