package com.example.project_1.view.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.project_1.R

@Composable
fun FormField(
    text: String,
    label: String,
    onTextChange: (String) -> Unit,
    password: Boolean = false
) {
    var passwordVisible by remember { mutableStateOf(password) }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = text,
        label = { Text(text = label) },
        onValueChange = onTextChange,
        visualTransformation = if (passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon =  { if (password) {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Image(painter = painterResource(id = R.drawable.eye), contentDescription = "eye")
            }
        }
        }
    )
}
