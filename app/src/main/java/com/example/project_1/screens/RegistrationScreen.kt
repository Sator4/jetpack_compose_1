package com.example.project_1.screens

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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project_1.MyActivitiesRoute
import com.example.project_1.R
import com.example.project_1.WelcomeScreenRoute
import com.example.project_1.screens.elements.WideButton
import com.example.project_1.screens.elements.FormField
import com.example.project_1.ui.theme.TextDarkPrimary

@Composable
fun RegistrationScreen(
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
                text = "Регистрация",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W600,
                color = TextDarkPrimary,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
        Column(
            Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                var login by remember { mutableStateOf("") }
                var username by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var repeatPassword by remember { mutableStateOf("") }
                FormField(login, { login = it })
                FormField(username, { username = it })
                FormField(password, { password = it }, true)
                FormField(repeatPassword, { repeatPassword = it }, true)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = "Пол",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W600,
                color = TextDarkPrimary,
                fontSize = 20.sp,
                lineHeight = 24.sp
            )
            val sexes = listOf("Мужской", "Женский", "Линолеум", "Ковролин")
            var selectedSex by remember { mutableStateOf(sexes[0]) }
            Column (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                sexes.forEach { sex ->
                    Row (
                        modifier = Modifier
                            .clickable {
                                selectedSex = sex
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        RadioButton(
                            modifier = Modifier
                                .size(20.dp),
                            selected = selectedSex == sex,
                            onClick = { selectedSex = sex }
                        )
                        Text(
                            text = sex,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Normal,
                            color = TextDarkPrimary,
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            modifier = Modifier.padding(start = 12.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            WideButton(
                onClick = { navController.navigate( MyActivitiesRoute ) },
                text = "Зарегистрироваться"
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                fontSize = 12.sp,
                lineHeight = 18.sp,
                style = TextStyle(textAlign = TextAlign.Center),
                text = buildAnnotatedString {
                    append("Нажимая на кнопку, вы соглашаетесь \nс ")
                    withLink(
                        LinkAnnotation.Url(
                            "https://wikipedia.org",
                            TextLinkStyles(style = SpanStyle(color = Color.Blue))
                        )
                    ){
                        append("политикой конфиденциальности")
                    }
                    append(" и обработки персональных данных, а также принимаете ")
                    withLink(
                        LinkAnnotation.Url(
                            "google.com",
                            TextLinkStyles(style = SpanStyle(color = Color.Blue))
                        )
                    ){
                        append("пользовательское соглашение")
                    }
                }
            )
        }
    }
}