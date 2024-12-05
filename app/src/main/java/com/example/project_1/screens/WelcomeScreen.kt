package com.example.project_1.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import com.example.project_1.LoginScreenRoute
import com.example.project_1.R
import com.example.project_1.RegistrationScreenRoute
import com.example.project_1.ui.theme.PrimaryBlue
import com.example.project_1.ui.theme.TextDarkPrimary
import com.example.project_1.ui.theme.TextDarkSecondary

@Composable
fun WelcomeScreen(
    navController: NavController
){
    val headline = "Пожалуй, лучший фитнес трекер в ДВФУ"
    val subheading = "Созданный студентами"
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(top = 88.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .padding(16.dp),
            painter = painterResource(R.drawable.welcome_screen_image),
            contentDescription = "WelcomeScreenImage"
        )
        Box (
            modifier = Modifier
                .padding(start = 32.dp, end = 32.dp)
        ){
            Text(
                text = headline,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = TextDarkPrimary,
                fontSize = 24.sp,
                lineHeight = 35.sp
            )
        }
        Box (
            modifier = Modifier
                .padding(top = 16.dp, bottom = 8.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = subheading,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                color = TextDarkSecondary,
                fontSize = 16.sp,
                lineHeight = 24.sp
            )
        }
        Box (
            modifier = Modifier
                .padding(16.dp)
        ){
            Button(
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                shape = RoundedCornerShape(corner = CornerSize(4.dp)),
                onClick = {
                    navController.navigate(RegistrationScreenRoute)
                }
            ) {
                Text(
                    text = "Зарегистрироваться",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 24.dp)
                )
            }
        }
        Box (){
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(corner = CornerSize(4.dp)),
                onClick = {
                    navController.navigate(LoginScreenRoute)
                }
            ) {
                Text(
                    text = "Уже есть аккаунт?",
                    fontSize = 16.sp,
                    color = PrimaryBlue
                )
            }
        }
    }
}