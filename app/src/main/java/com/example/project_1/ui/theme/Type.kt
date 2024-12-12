package com.example.project_1.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun W400_16_24(
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
fun W700_24_35(
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