package com.example.project_1.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.project_1.R
import com.example.project_1.ui.theme.ButtonPrimary
import com.example.project_1.ui.theme.TextDarkPrimary
import com.example.project_1.ui.theme.TextDarkSecondary

@Composable
fun WelcomeScreen(){
    val headline = "Пожалуй, лучший фитнес трекер в ДВФУ"
    val subheading = "Созданный студентами"
    val constraints = ConstraintSet {
        val image = createRefFor("image")
        val headline = createRefFor("headline")
        val subheading = createRefFor("subheading")
        val registerButton = createRefFor("registerButton")
        val loginButton = createRefFor("loginButton")

        val topGuideLine = createGuidelineFromTop(96.dp)

        constrain(image){
            top.linkTo(topGuideLine)
            start.linkTo(parent.start)
        }
        constrain(headline){
            top.linkTo(image.bottom)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
        }
        constrain(subheading){
            top.linkTo(headline.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(registerButton){
            top.linkTo(subheading.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(loginButton){
            top.linkTo(registerButton.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
    ConstraintLayout(
        constraints,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            modifier = Modifier
                .layoutId("image")
                .padding(16.dp),
            painter = painterResource(R.drawable.welcome_screen_image),
            contentDescription = "WelcomeScreenImage"
        )
        Box (
            modifier = Modifier
                .layoutId("headline")
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
                .layoutId("subheading")
                .padding(top = 16.dp, bottom = 8.dp)
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
                .layoutId("registerButton")
                .padding(16.dp)
        ){
            Button(
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(containerColor = ButtonPrimary),
                shape = RoundedCornerShape(corner = CornerSize(4.dp)),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Зарегистрироваться",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 24.dp)
                )
            }
        }
        Box (modifier = Modifier.layoutId("loginButton")){
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(corner = CornerSize(4.dp)),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Уже есть аккаунт?",
                    fontSize = 16.sp,
                    color = ButtonPrimary
                )
            }
        }
    }
}