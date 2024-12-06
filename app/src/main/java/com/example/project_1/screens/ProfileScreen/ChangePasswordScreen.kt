package com.example.project_1.screens.ProfileScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project_1.ProfileScreenRoute
import com.example.project_1.R
import com.example.project_1.screens.ActivitiesScreen.ActivitiesFooter
import com.example.project_1.screens.elements.FormField
import com.example.project_1.screens.elements.WideButton
import com.example.project_1.ui.theme.PrimaryBlue
import com.example.project_1.ui.theme.TextDarkPrimary

@Composable
fun ChangePasswordScreen(
    navController: NavController
){
    Column {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            IconButton(
                modifier = Modifier
                    .size(24.dp),
                onClick = { navController.navigate(ProfileScreenRoute) }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back_arrow),
                    contentDescription = ""
                )
            }
            Text(
                text = "Изменить пароль",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W600,
                color = TextDarkPrimary,
                fontSize = 20.sp,
                lineHeight = 24.sp
            )
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            var old_password by remember { mutableStateOf("") }
            var new_password by remember { mutableStateOf("") }
            var repeat_password by remember { mutableStateOf("") }
            FormField(text = old_password, onTextChange = { old_password = it })
            Spacer(modifier = Modifier.height(0.dp))
            FormField(text = new_password, onTextChange = { new_password = it })
            FormField(text = repeat_password, onTextChange = { repeat_password = it })
            Spacer(modifier = Modifier.height(0.dp))
            WideButton(
                navigate = { navController.navigate( ProfileScreenRoute ) },
                color = PrimaryBlue,
                text = "Принять"
            )
        }
        ActivitiesFooter(navController = navController, currentTab = 1)
    }
}