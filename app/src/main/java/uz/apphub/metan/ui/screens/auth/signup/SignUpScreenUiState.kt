package uz.apphub.metan.ui.screens.auth.signup

/**
 * Created By Shokirov Begzod on 8/20/2024
 **/
data class SignUpScreenUiState(
    val data: Boolean? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val login: String = "",
    val password: String = "",
    val loginError: String = "",
    val passwordError: String = "",
)
