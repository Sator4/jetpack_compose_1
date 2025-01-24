package com.example.project_1.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject internal constructor(): ViewModel() {
    fun checkPassword(password: String): String{
        if (password.length < 6){
            return "Длина пароля должна быть больше 5 символов"
        }
        if (password.lowercase() == password || password.uppercase() == password){
            return "Пароль должен содержать буквы верхнего и нижнего регистра"
        }
        if (!password.contains(Regex("\\d"))){
            return "Пароль должен содержать цифры"
        }
        return ""
    }
}