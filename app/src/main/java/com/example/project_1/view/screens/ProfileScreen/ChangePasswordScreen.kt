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
import com.example.project_1.view.elements.BottomNavigation
import com.example.project_1.view.elements.FormField
import com.example.project_1.view.elements.TopBar
import com.example.project_1.view.elements.WideButton
import com.example.project_1.ui.theme.PrimaryBlue

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
            var old_password by remember { mutableStateOf("") }
            var new_password by remember { mutableStateOf("") }
            var repeat_password by remember { mutableStateOf("") }
            FormField(old_password, "Старый пароль", { old_password = it }, password = true)
            Spacer(modifier = Modifier.height(0.dp))
            FormField(new_password, "Новый пароль", { new_password = it }, password = true)
            FormField(repeat_password, "Повторите пароль", { repeat_password = it }, password = true)
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