package com.example.project_1.screens.ActivitiesScreen

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project_1.ui.theme.BackgroundGray
import com.example.project_1.ui.theme.PrimaryBlue
import com.example.project_1.ui.theme.TextDarkPrimary
import com.example.project_1.ui.theme.TextDarkSecondary

//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.setValue

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ActivitiesScreen(
    navController: NavController
){
    val activitiesList = remember { mutableListOf<ActivityClass>() }
    activitiesList.add( ActivityClass(
        distance = "9874 m",
        time = "2 h 14 m 43 s",
        activity = "Running",
        date = "03.12.24"
    )
    )
    Scaffold(
        containerColor = BackgroundGray,
        topBar = {
            ActivitiesHeader(
                navController = navController,
                currentTab = 0,
                selectHeaderTab = {  }
            )
        },
        bottomBar = {
            ActivitiesFooter(
                navController = navController,
                currentTab = 0,
                selectFooterTab = { }
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
                onClick = { /*TODO*/ }
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
            items(activitiesList) { card ->
                ActivityCard(card.distance, card.time, card.activity, card.date)
            }
        }
    }
}


class ActivityClass(
    val distance: String,
    val time: String,
    val activity: String,
    val date: String
)


@Composable
fun EmptyPlaceholder(
){
    Column(
        modifier = Modifier
            .padding(horizontal = 40.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Время потренить",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W700,
            color = TextDarkPrimary,
            fontSize = 24.sp,
            lineHeight = 35.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Нажимай на кнопку ниже и начинаем трекать активность",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W400,
            color = TextDarkSecondary,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}