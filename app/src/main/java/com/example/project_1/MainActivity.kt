package com.example.project_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project_1.screens.ActivityDetailsScreen.ActivityDetailsScreen
import com.example.project_1.screens.ActivitiesScreen.MyActivitiesScreen
import com.example.project_1.screens.ActivitiesScreen.OthersActivitiesScreen
import com.example.project_1.screens.LoginScreen.LoginScreen
import com.example.project_1.screens.NewActivityScreen.NewActivityScreen
import com.example.project_1.screens.ProfileScreen.ChangePasswordScreen
import com.example.project_1.screens.ProfileScreen.ProfileScreen
import com.example.project_1.screens.RegistrationScreen.RegistrationScreen
import com.example.project_1.screens.WelcomeScreen.WelcomeScreen
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            Box(
                modifier = Modifier.systemBarsPadding()
            ){
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = MyActivitiesScreenRoute,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
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
                    composable<MyActivitiesScreenRoute> {
                        MyActivitiesScreen(navController)
                    }
                    composable<OthersActivitiesScreenRoute> {
                        OthersActivitiesScreen(navController)
                    }
                    composable<ProfileScreenRoute> {
                        ProfileScreen(navController)
                    }
                    composable<ChangePasswordScreenRoute> {
                        ChangePasswordScreen(navController)
                    }
//                    composable<ActivityDetailsScreenRoute> {
//                        val args = it.toRoute<ActivityDetailsScreenRoute>()
//                        ActivityDetailsScreen(navController, args.activity)
//                    }
                    composable<ActivityDetailsScreenRoute>{
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
object MyActivitiesScreenRoute

@Serializable
object OthersActivitiesScreenRoute

@Serializable
object ProfileScreenRoute

@Serializable
object ChangePasswordScreenRoute

@Serializable
object ActivityDetailsScreenRoute
//data class ActivityDetailsScreenRoute (
//    val activity: ActivityClass
//)

@Serializable
object NewActivityScreenRoute