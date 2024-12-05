package com.example.project_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project_1.screens.ActivitiesScreen.ActivitiesScreen
import com.example.project_1.screens.LoginScreen
import com.example.project_1.screens.RegistrationScreen
import com.example.project_1.screens.WelcomeScreen
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            Box(
                modifier = Modifier.padding(vertical = 24.dp)
            ){
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = LoginScreenRoute
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
                    composable<ActivitiesScreenRoute> {
                        ActivitiesScreen(navController)
                    }
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

@Serializable
object ActivitiesScreenRoute

@Serializable
object ProfileScreenRoute

@Serializable
object ActivityDetailsScreenRoute

@Serializable
object NewActivityScreenRoute