package com.example.project_1.screens.ActivitiesScreen.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project_1.ui.theme.TextDarkPrimary
import com.example.project_1.ui.theme.TextDarkSecondary
import com.example.project_1.ui.theme.W400_16_24
import com.example.project_1.ui.theme.W700_24_35

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
        W700_24_35("Время потренить", TextDarkPrimary)
        Spacer(modifier = Modifier.height(8.dp))
        W400_16_24("Нажимай на кнопку ниже и начинаем трекать активность", TextDarkSecondary)
    }
}