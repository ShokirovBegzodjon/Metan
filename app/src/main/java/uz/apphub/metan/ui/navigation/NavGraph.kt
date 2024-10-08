package uz.apphub.metan.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import uz.apphub.metan.ui.screens.auth.signin.SignInScreen
import uz.apphub.metan.ui.screens.auth.signup.SignUpScreen
import uz.apphub.metan.ui.screens.home.HomeScreen
import uz.apphub.metan.utils.Constants.Companion.EMAIL

/**
 * Created By Shokirov Begzod on 9/24/2024
 **/

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController= navController,
        startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route){
            HomeScreen(navController)
        }

        composable(route = Screen.SignIn.route){
            SignInScreen(navController)
        }

        composable(
            route = Screen.SignUp.route,
            arguments = listOf(
                navArgument(EMAIL){type = NavType.StringType}
            )
        ){
            SignUpScreen(navController)
        }
    }
}