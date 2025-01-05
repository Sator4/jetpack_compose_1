package com.example.project_1.ui.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun RegularFont(
    text: String,
    color: Color,
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W400,
        color = color,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        modifier = modifier
    )
}

@Composable
fun BigFont(
    text: String,
    color: Color,
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W700,
        color = color,
        fontSize = 24.sp,
        lineHeight = 35.sp,
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}