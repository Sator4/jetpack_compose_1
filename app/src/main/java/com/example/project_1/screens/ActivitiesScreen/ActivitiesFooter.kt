package com.example.project_1.screens.ActivitiesScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project_1.MyActivitiesRoute
import com.example.project_1.ProfileScreenRoute
import com.example.project_1.R
import com.example.project_1.ui.theme.PrimaryBlue
import com.example.project_1.ui.theme.TextDarkPrimary

@Composable
fun ActivitiesFooter(
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
                .fillMaxWidth().weight(1f)
                .height(56.dp)
                .clickable { navController.navigate( MyActivitiesRoute ) },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Icon(painter = if (currentTab == 0) painterResource(id = R.drawable.whistle_blue) else painterResource(id = R.drawable.whistle_grey), contentDescription = "")
            Text(
                text = "Активность",
                color = if (currentTab == 0) PrimaryBlue else TextDarkPrimary
            )
        }
        Column (
            modifier = Modifier
                .fillMaxWidth().weight(1f)
                .height(56.dp)
                .clickable { navController.navigate(ProfileScreenRoute) },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Icon(painter = if (currentTab == 1) painterResource(id = R.drawable.person_blue) else painterResource(id = R.drawable.person_grey), contentDescription = "")
            Text(
                text = "Профиль",
                color = if (currentTab == 1) PrimaryBlue else TextDarkPrimary
            )
        }
    }
}