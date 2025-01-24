package com.example.project_1.view.screens.NewActivityScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_1.R
import com.example.project_1.model.room.Activity
import com.example.project_1.ui.theme.BigFont
import com.example.project_1.ui.theme.PrimaryBlue
import com.example.project_1.ui.theme.TextDarkPrimary
import java.time.ZonedDateTime
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun RunningActivity(
    finishActivity: (Activity) -> Unit,
    activityName: String
){
    val currentActivity by remember { mutableStateOf(
        Activity(
            activityType = activityName,
            distance = 0.0,
            startTime = ZonedDateTime.now().toInstant().toEpochMilli(),
            finishTime = ZonedDateTime.now().toInstant().toEpochMilli(),
        ))
    }
    Box (modifier = Modifier.clip(shape = RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp))){
        Column(
            modifier = Modifier
                .background(Color.Gray)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BigFont(text = activityName, color = TextDarkPrimary)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = currentActivity.distance.toString() + "м",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W400,
                    color = TextDarkPrimary,
                    fontSize = 24.sp,
                    lineHeight = 35.sp
                )
                Text(
                    text = (currentActivity.finishTime - currentActivity.startTime).milliseconds.toString(),
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
                onClick = { finishActivity(currentActivity) }
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