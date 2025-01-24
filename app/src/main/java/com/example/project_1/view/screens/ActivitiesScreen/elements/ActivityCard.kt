package com.example.project_1.view.screens.ActivitiesScreen.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.project_1.model.room.Activity
import com.example.project_1.ui.theme.BigFont
import com.example.project_1.ui.theme.PrimaryBlue
import com.example.project_1.ui.theme.RegularFont
import com.example.project_1.ui.theme.TextDarkSecondary

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
                BigFont(activity.distance.toString() + " м")
                if (activity.usertag != ""){
                    RegularFont(activity.usertag, Modifier.clickable {  }, PrimaryBlue)
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            RegularFont((activity.finishTime - activity.startTime).toString())
            Spacer(modifier = Modifier.height(4.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                RegularFont(activity.activityType)
                RegularFont(activity.startTime.toString(), color = TextDarkSecondary)
            }
        }
    }
}