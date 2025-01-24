package com.example.project_1.screens.ActivitiesScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project_1.MyActivitiesRoute
import com.example.project_1.OthersActivitiesRoute
import com.example.project_1.ui.theme.PrimaryBlue

@Composable
fun ActivitiesHeader(
    navController: NavController,
    currentTab: Int
){
    Row (
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
    ){
        Column (
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth().weight(1f)
                .height(48.dp)
                .clickable { navController.navigate(MyActivitiesRoute) },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Color.White)
            )
            Text(
                text = "Моя"
            )
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(if (currentTab == 0) PrimaryBlue else Color.White)
            )
        }
        Column (
            modifier = Modifier
                .fillMaxWidth().weight(1f)
                .height(48.dp)
                .clickable { navController.navigate(OthersActivitiesRoute) },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Color.White)
            )
            Text(text = "Пользователей")
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(if (currentTab == 1) PrimaryBlue else Color.White)
            )
        }
    }
}