package com.example.project_1.screens.elements

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_1.ui.theme.PrimaryBlue
import com.example.project_1.ui.theme.TextDarkPrimary
import com.example.project_1.ui.theme.TextDarkSecondary

@Composable
fun ActivityCard(
    distance: String,
    time: String,
    activity: String,
    date: String,
    usertag: String? = null
){
    Box(
        modifier = Modifier
//            .background(Color.Red)
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(2.dp)
            .border(
                border = BorderStroke(0.dp, Color.Transparent),
                shape = RoundedCornerShape(4.dp)
            )
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
                Text(
                    text = distance,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W700,
                    color = TextDarkPrimary,
                    fontSize = 24.sp,
                    lineHeight = 35.sp
                )
                if (usertag != null){
                    Text(
                        text = usertag,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.W400,
                        color = PrimaryBlue,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        modifier = Modifier.clickable {  }
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = time,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W400,
                color = TextDarkPrimary,
                fontSize = 16.sp,
                lineHeight = 24.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = activity,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W400,
                    color = TextDarkPrimary,
                    fontSize = 16.sp,
                    lineHeight = 24.sp
                )
                Text(
                    text = date,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W400,
                    color = TextDarkSecondary,
                    fontSize = 16.sp,
                    lineHeight = 24.sp
                )
            }
        }
    }
}