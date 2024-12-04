package com.example.project_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project_1.screens.LoginScreen
import com.example.project_1.screens.RegistrationScreen
import com.example.project_1.screens.WelcomeScreen
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = WelcomeScreenRoute
            ){
                composable<WelcomeScreenRoute>{
                    WelcomeScreen(navController)
                }
                composable<LoginScreenRoute> {
                    LoginScreen(navController)
                }
                composable<RegistrationScreenRoute> {
                    RegistrationScreen(navController)
                }
            }

        }
    }
}

@Serializable
object WelcomeScreenRoute

@Serializable
object LoginScreenRoute

@Serializable
object RegistrationScreenRoute