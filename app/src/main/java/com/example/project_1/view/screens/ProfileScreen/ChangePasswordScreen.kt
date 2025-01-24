package com.example.project_1.view.screens.ProfileScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project_1.Screen
import com.example.project_1.ui.theme.PrimaryBlue
import com.example.project_1.view.elements.BottomNavigation
import com.example.project_1.view.elements.FormField
import com.example.project_1.view.elements.TopBar
import com.example.project_1.view.elements.WideButton

@Composable
fun ChangePasswordScreen(
    navController: NavController
){
    Column {
        TopBar(
            navigate = { navController.navigate(Screen.ProfileScreenRoute.route) },
            header = "Изменить пароль"
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            var oldPassword by remember { mutableStateOf("") }
            var newPassword by remember { mutableStateOf("") }
            var repeatPassword by remember { mutableStateOf("") }
            FormField(oldPassword, "Старый пароль", { oldPassword = it }, password = true)
            Spacer(modifier = Modifier.height(0.dp))
            FormField(newPassword, "Новый пароль", { newPassword = it }, password = true)
            FormField(repeatPassword, "Повторите пароль", { repeatPassword = it }, password = true)
            Spacer(modifier = Modifier.height(0.dp))
            WideButton(
                onClick = { navController.navigate(Screen.ProfileScreenRoute.route) },
                color = PrimaryBlue,
                text = "Принять"
            )
        }
        BottomNavigation(navController = navController, currentTab = 1)
    }
}