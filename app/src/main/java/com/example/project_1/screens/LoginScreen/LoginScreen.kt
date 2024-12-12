package com.example.project_1.screens.LoginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project_1.MyActivitiesScreenRoute
import com.example.project_1.R
import com.example.project_1.WelcomeScreenRoute
import com.example.project_1.screens.elements.FormField
import com.example.project_1.screens.elements.TopBar
import com.example.project_1.screens.elements.WideButton

@Composable
fun LoginScreen(
    navController: NavController
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TopBar(
            navigate = { navController.navigate(WelcomeScreenRoute) },
            header = "Вход"
        )
        Image(
            modifier = Modifier
                .padding(horizontal = 70.dp, vertical = 16.dp),
            painter = painterResource(R.drawable.welcome_screen_image),
            contentDescription = "WelcomeScreenImage"
        )
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            var login by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            FormField(login, "Логин", { login = it })
            FormField(password, "Пароль", { password = it }, true)
            Spacer(modifier = Modifier.height(0.dp))
            WideButton(
                onClick = { navController.navigate( MyActivitiesScreenRoute ) },
                text = "Войти"
            )
        }
    }
}