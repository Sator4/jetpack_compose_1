package com.example.project_1.view.screens.ActivityDetailsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_1.ui.theme.PrimaryBlue
import com.example.project_1.ui.theme.TextDarkPrimary

@Composable
fun ConfirmDelete(
    onClickYes: () -> Unit,
    onClickNo: () -> Unit
){
    Box (
        modifier = Modifier
            .background(Color(0x88000000))
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(Color.LightGray)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Точно удалить?",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W500,
                color = TextDarkPrimary,
                fontSize = 20.sp,
                lineHeight = 28.sp
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    modifier = Modifier
                        .height(32.dp),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                    shape = RoundedCornerShape(corner = CornerSize(4.dp)),
                    onClick = { onClickYes() }
                ) {
                    Text(
                        text = "Да",
                        fontSize = 16.sp
                    )
                }
                Button(
                    modifier = Modifier
                        .height(32.dp),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                    shape = RoundedCornerShape(corner = CornerSize(4.dp)),
                    onClick = { onClickNo() }
                ) {
                    Text(
                        text = "Нет",
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}