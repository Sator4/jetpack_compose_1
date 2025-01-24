package com.example.project_1.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project_1.ActivityDetailsScreenRoute
import com.example.project_1.MyActivitiesRoute
import com.example.project_1.R
import com.example.project_1.screens.elements.WideButton
import com.example.project_1.ui.theme.PrimaryBlue
import com.example.project_1.ui.theme.TextDarkPrimary
import com.example.project_1.ui.theme.ThinBorderGray
import com.example.project_1.ui.theme.W400_16_24
import com.example.project_1.ui.theme.W700_24_35

@Composable
fun NewActivityScreen(
    navController: NavController
){
    var state by remember { mutableStateOf(0) }
    var activityName by remember { mutableStateOf("") }
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (state == 0) navController.navigate(MyActivitiesRoute)
                    else state = 0
                }
            ) {
                Icon(painter = painterResource(id = R.drawable.back_arrow), contentDescription = "back")
            }
            if (state == 0){
                SelectActivity(
                    changeState =  { newState -> if (activityName != "") state = newState },
                    selectActivity = { newActivity -> activityName = newActivity },
                    activityName = activityName
                )
            }
            else {
                RunningActivity(
                    changeState = { navController.navigate(ActivityDetailsScreenRoute) },
                    activityName = activityName
                )
            }
        }

    }
}

@Composable
fun SelectActivity(
    changeState: (Int) -> Unit,
    selectActivity: (String) -> Unit,
    activityName: String
){
    Box (modifier = Modifier.clip(shape = RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp))){
        Column(
            modifier = Modifier
                .background(Color.Gray)
                .padding(horizontal = 16.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            val activities = mutableListOf("Велосипед", "Бег", "Ходьба")
            W700_24_35(text = "Гойда?", color = TextDarkPrimary)
            LazyRow (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(activities) { activity ->
                    Row(
                        modifier = Modifier
                            .border(
                                border =
                                if (activityName != activity)
                                    BorderStroke(1.dp, ThinBorderGray)
                                else
                                    BorderStroke(2.dp, PrimaryBlue),
                                shape = RoundedCornerShape(14.dp)
                            )
                            .clickable { selectActivity(activity) }
                    ) {
                        W400_16_24(activity, TextDarkPrimary, Modifier.padding(vertical = 30.dp, horizontal = 16.dp))
                    }
                }
            }
            WideButton(onClick = { changeState(1) }, text = "Начать")
        }
    }
}

@Composable
fun RunningActivity(
    changeState: () -> Unit,
    activityName: String
){
    Box (modifier = Modifier.clip(shape = RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp))){
        Column(
            modifier = Modifier
                .background(Color.Gray)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            W700_24_35(text = activityName, color = TextDarkPrimary)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "14 км",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W400,
                    color = TextDarkPrimary,
                    fontSize = 24.sp,
                    lineHeight = 35.sp
                )
                Text(
                    text = "00:01:46",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W400,
                    color = TextDarkPrimary,
                    fontSize = 24.sp,
                    lineHeight = 35.sp
                )
            }
            Button(
                modifier = Modifier.size(56.dp),
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                onClick = { changeState() }
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.racing_flag),
                    contentDescription = "finish"
                )
            }
        }
    }
}