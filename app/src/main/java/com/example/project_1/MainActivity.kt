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
import com.example.project_1.screens.ActivitiesScreen.ActivityDetailsScreen
import com.example.project_1.screens.ActivitiesScreen.MyActivities
import com.example.project_1.screens.ActivitiesScreen.OthersActivities
import com.example.project_1.screens.LoginScreen
import com.example.project_1.screens.NewActivityScreen
import com.example.project_1.screens.ProfileScreen.ChangePasswordScreen
import com.example.project_1.screens.ProfileScreen.ProfileScreen
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
                    startDestination = MyActivitiesRoute
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
                    composable<MyActivitiesRoute> {
                        MyActivities(navController)
                    }
                    composable<OthersActivitiesRoute> {
                        OthersActivities(navController)
                    }
                    composable<ProfileScreenRoute> {
                        ProfileScreen(navController)
                    }
                    composable<ChangePasswordScreenRoute> {
                        ChangePasswordScreen(navController)
                    }
                    composable<ActivityDetailsScreenRoute> {
                        ActivityDetailsScreen(navController)
                    }
                    composable<NewActivityScreenRoute> {
                        NewActivityScreen(navController)
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
object MyActivitiesRoute

@Serializable
object OthersActivitiesRoute

@Serializable
object ProfileScreenRoute

@Serializable
object ChangePasswordScreenRoute

@Serializable
object ActivityDetailsScreenRoute

@Serializable
object NewActivityScreenRoute