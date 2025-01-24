package com.example.project_1.view.screens.NewActivityScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.project_1.ui.theme.BigFont
import com.example.project_1.ui.theme.PrimaryBlue
import com.example.project_1.ui.theme.RegularFont
import com.example.project_1.ui.theme.TextDarkPrimary
import com.example.project_1.ui.theme.ThinBorderGray
import com.example.project_1.view.elements.WideButton

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
            val activities = listOf("Бипки", "Нюанс", "Бирюльки")
            BigFont(text = "Внимание, анекдот", color = TextDarkPrimary)
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
                        RegularFont(activity, Modifier.padding(vertical = 30.dp, horizontal = 16.dp))
                    }
                }
            }
            WideButton(onClick = { changeState(1) }, text = "Начать")
        }
    }
}