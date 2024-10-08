package uz.apphub.metan.ui.navigation

import uz.apphub.metan.utils.Constants.Companion.EMAIL

/**
 * Created By Shokirov Begzod on 9/24/2024
 **/
sealed class Screen(
    val route: String,
) {
    data object SignIn: Screen(
        route = "sign_in"
    )

    data object SignUp: Screen(
        route = "sign_up/{$EMAIL}"
    ) {
        fun email(email: String,): String {
            return "sign_up/${email}"
        }
    }

    data object Home: Screen(
        route = "home"
    )
}
