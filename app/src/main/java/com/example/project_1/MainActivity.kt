package com.example.project_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.project_1.view.screens.ActivitiesScreen.MyActivitiesScreen
import com.example.project_1.view.screens.ActivitiesScreen.OthersActivitiesScreen
import com.example.project_1.view.screens.ActivityDetailsScreen.ActivityDetailsScreen
import com.example.project_1.view.screens.LoginScreen.LoginScreen
import com.example.project_1.view.screens.NewActivityScreen.NewActivityScreen
import com.example.project_1.view.screens.ProfileScreen.ChangePasswordScreen
import com.example.project_1.view.screens.ProfileScreen.ProfileScreen
import com.example.project_1.view.screens.RegistrationScreen.RegistrationScreen
import com.example.project_1.view.screens.WelcomeScreen.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    private val database = ActivitiesDatabase.getDatabase(applicationContext)
//
//    private val viewModelFactory = object : ViewModelProvider.Factory {
//        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//            return ActivitiesViewModel(database.activityDao()) as T
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.systemBarsPadding()
            ){
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.MyActivitiesScreenRoute.route,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ){
                    composable(Screen.WelcomeScreenRoute.route) {
                        WelcomeScreen(navController)
                    }
                    composable(Screen.LoginScreenRoute.route) {
                        LoginScreen(navController)
                    }
                    composable(Screen.RegistrationScreenRoute.route) {
                        RegistrationScreen(navController)
                    }
                    composable(Screen.MyActivitiesScreenRoute.route) {
                        MyActivitiesScreen(navController)
                    }
                    composable(Screen.OthersActivitiesScreenRoute.route) {
                        OthersActivitiesScreen(navController)
                    }
                    composable(Screen.ProfileScreenRoute.route) {
                        ProfileScreen(navController)
                    }
                    composable(Screen.ChangePasswordScreenRoute.route) {
                        ChangePasswordScreen(navController)
                    }
                    composable(
                        route = Screen.ActivityDetailsScreenRoute.route + "/{id}",
                        arguments = listOf(
                            navArgument("id"){ type = NavType.IntType })
                    ) { entry ->
                        entry.arguments?.let {
                            ActivityDetailsScreen(
                                navController = navController,
                                activityId = it.getInt("id")
                            )
                        }
                    }
                    composable(Screen.NewActivityScreenRoute.route) {
                        NewActivityScreen(navController)
                    }
                }

            }

        }
    }
}


sealed class Screen(val route: String){
    object WelcomeScreenRoute : Screen("welcome_screen_route")
    object LoginScreenRoute : Screen("login_screen_route")
    object RegistrationScreenRoute : Screen("registration_screen_route")
    object MyActivitiesScreenRoute : Screen("my_activities_screen_route")
    object OthersActivitiesScreenRoute : Screen("others_activities_screen_route")
    object ProfileScreenRoute : Screen("profile_screen_route")
    object ChangePasswordScreenRoute : Screen("change_password_screen_route")
    object ActivityDetailsScreenRoute : Screen("activity_details_screen_route")
    object NewActivityScreenRoute : Screen("new_activity_screen_route")
}
