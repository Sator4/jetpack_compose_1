package com.example.project_1.screens.ProfileScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project_1.ChangePasswordScreenRoute
import com.example.project_1.WelcomeScreenRoute
import com.example.project_1.screens.elements.BottomNavigation
import com.example.project_1.screens.elements.FormField
import com.example.project_1.screens.elements.WideButton
import com.example.project_1.ui.theme.PrimaryBlue
import com.example.project_1.ui.theme.TextDarkPrimary

@Composable
fun ProfileScreen(
    navController: NavController
){
    Column {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Профиль",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W600,
                color = TextDarkPrimary,
                fontSize = 20.sp,
                lineHeight = 24.sp
            )
            Text(
                text = "Сохранить",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W700,
                color = PrimaryBlue,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                modifier = Modifier.clickable {  }
            )
        }
        Column (
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                var login by remember { mutableStateOf("") }
                var username by remember { mutableStateOf("") }
                FormField(login, "Логин", { login = it })
                FormField(username, "Имя или никнейм", { username = it })
                Box(
                    modifier = Modifier
                        .padding(vertical = 12.dp, horizontal = 16.dp)
                        .fillMaxWidth()
                ){
                    Text(
                        text = "Изменить пароль",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.W700,
                        color = PrimaryBlue,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        modifier = Modifier.clickable {
                            navController.navigate(ChangePasswordScreenRoute)
                        }
                    )
                }
            }
        Spacer(modifier = Modifier.weight(1f))
        WideButton(
            onClick = { navController.navigate( WelcomeScreenRoute ) },
            text = "Выйти"
        )
        }
        BottomNavigation(
            navController = navController,
            currentTab = 1
        )
    }
}