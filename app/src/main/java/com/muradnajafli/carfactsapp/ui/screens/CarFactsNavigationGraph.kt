package com.muradnajafli.carfactsapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.muradnajafli.carfactsapp.ui.UserInputViewModel

@Composable
fun CarFactsNavigationGraph(
    userInputViewModelFactory: UserInputViewModel = viewModel()
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.USER_INPUT_SCREEN
    ) {
        composable(Routes.USER_INPUT_SCREEN) {
            UserInputScreen(userInputViewModelFactory, showWelcomeScreen = {
                navController.navigate(Routes.WELCOME_SCREEN+"/${it.first}/${it.second}")
            })
        }

        composable("${Routes.WELCOME_SCREEN}/{${Routes.USER_NAME}}/{${Routes.CAR}}",
            arguments = listOf(
                navArgument(Routes.USER_NAME) { type = NavType.StringType },
                navArgument(Routes.CAR) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString(Routes.USER_NAME)
            val car = backStackEntry.arguments?.getString(Routes.CAR)
            WelcomeScreen(userName, car)
        }
    }
}