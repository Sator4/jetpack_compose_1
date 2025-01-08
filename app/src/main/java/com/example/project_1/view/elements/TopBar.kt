package com.example.project_1.view.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_1.R
import com.example.project_1.ui.theme.TextDarkPrimary

@Composable
fun TopBar(
    navigate: () -> Unit,
    header: String,
    myActivityDetails: Boolean = false,
    myActivityActions: Array<() -> Unit> = arrayOf()
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            modifier = Modifier
                .clickable {
                    navigate()
                },
            painter = painterResource(id = R.drawable.back_arrow),
            contentDescription = "back_arrow",
        )
        Text(
            text = header,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W600,
            color = TextDarkPrimary,
            fontSize = 20.sp,
            lineHeight = 24.sp,
        )
        if (myActivityDetails){
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = { myActivityActions[0]() }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.trash),
                    contentDescription = "delete"
                )
            }
            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = { myActivityActions[1]() }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = "share"
                )
            }
        }
    }
}