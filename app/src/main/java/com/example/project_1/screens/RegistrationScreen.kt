package com.example.project_1.screens

import android.provider.MediaStore.Audio.Radio
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.widget.EditText
import android.widget.RadioButton
import android.widget.ScrollView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutInput
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import com.example.project_1.R
import com.example.project_1.WelcomeScreenRoute
import com.example.project_1.ui.theme.ButtonPrimary
import com.example.project_1.ui.theme.TextDarkPrimary
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    navController: NavController
){
    val constraints = ConstraintSet {
        val topBar = createRefFor("topBar")
        val form = createRefFor("form")
        val registerButton = createRefFor("registerButton")
        val privacyPolicy = createRefFor("privacyPolicy")

        val topGuideLine = createGuidelineFromTop(24.dp)

        constrain(topBar){
            top.linkTo(topGuideLine)
            start.linkTo(parent.start)

        }
        constrain(form){
            top.linkTo(topBar.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(registerButton){
            top.linkTo(form.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(privacyPolicy){
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
        Row(
           modifier = Modifier
               .layoutId("topBar"),
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
                fontWeight = FontWeight.Bold,
                color = TextDarkPrimary,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
        Column (
            modifier = Modifier
                .layoutId("form")
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
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
                text = "Пол",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                color = TextDarkPrimary,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            val sexes = listOf("Мужской", "Женский", "Линолеум", "Ковролин")
            var selectedSex by remember { mutableStateOf(sexes[0]) }
            Column (
                modifier = Modifier
//                    .background(Color.Red)
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                sexes.forEach { sex ->
                    Row (
                        modifier = Modifier
//                            .background(Color.Cyan)
                            .clickable {
                                selectedSex = sex
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        RadioButton(
                            modifier = Modifier
//                                .background(Color.Blue)
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
        }
        Button(
            modifier = Modifier
                .layoutId("registerButton")
                .fillMaxWidth()
                .padding(16.dp),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(containerColor = ButtonPrimary),
            shape = RoundedCornerShape(corner = CornerSize(4.dp)),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Зарегистрироваться",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box (
            modifier = Modifier
                .layoutId("privacyPolicy")
                .padding(horizontal = 16.dp)
            ){
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

@Composable
fun FormField(
    text: String,
    onTextChange: (String) -> Unit,
    password: Boolean = false
) {
    var passwordVisible by remember { mutableStateOf(password) }
    OutlinedTextField(
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth(),
        value = text,
        onValueChange = onTextChange,
        visualTransformation = if (passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon =  { if (password) {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(painter = painterResource(id = R.drawable.eye), contentDescription = "eye")
                }
            }
        }
    )
}
