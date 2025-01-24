package com.example.project_1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project_1.MyActivitiesRoute
import com.example.project_1.R
import com.example.project_1.WelcomeScreenRoute
import com.example.project_1.screens.elements.FormField
import com.example.project_1.screens.elements.WideButton
import com.example.project_1.ui.theme.TextDarkPrimary

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
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clickable {
                        navController.navigate(WelcomeScreenRoute)
                    },
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "back_arrow"
            )
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Вход",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W600,
                color = TextDarkPrimary,
                fontSize = 20.sp,
                lineHeight = 24.sp,
            )
        }
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
            FormField(login, { login = it })
            FormField(password, { password = it }, true)
            Spacer(modifier = Modifier.height(0.dp))
            WideButton(
                onClick = { navController.navigate( MyActivitiesRoute ) },
                text = "Войти"
            )
        }
    }
}