package com.example.project_1.view.screens.ActivitiesScreen.elements

import androidx.compose.foundation.BorderStroke
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
import com.example.project_1.Screen
import com.example.project_1.model.room.Activity
import com.example.project_1.ui.theme.PrimaryBlue
import com.example.project_1.ui.theme.TextDarkPrimary
import com.example.project_1.ui.theme.TextDarkSecondary
import com.example.project_1.ui.theme.RegularFont
import com.example.project_1.ui.theme.BigFont

@Composable
fun ActivityCard(
    activity: Activity,
    onClick: () -> Unit
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
            .clickable { onClick() }
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
                BigFont(activity.distance, TextDarkPrimary)
                if (activity.usertag != null){
                    RegularFont(activity.usertag, PrimaryBlue, Modifier.clickable {  })
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            RegularFont(activity.time, TextDarkPrimary)
            Spacer(modifier = Modifier.height(4.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                RegularFont(activity.activityType, TextDarkPrimary)
                RegularFont(activity.date, TextDarkSecondary)
            }
        }
    }
}