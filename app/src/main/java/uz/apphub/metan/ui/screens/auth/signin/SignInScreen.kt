package uz.apphub.metan.ui.screens.auth.signin

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import uz.apphub.metan.ui.components.ButtonComponent
import uz.apphub.metan.ui.components.ErrorDialogComponent
import uz.apphub.metan.ui.components.LoadingDialogComponent
import uz.apphub.metan.ui.components.PasswordTextFieldComponent
import uz.apphub.metan.ui.components.TextComponent
import uz.apphub.metan.ui.components.TextFieldComponent
import uz.apphub.metan.ui.components.TopBarComponent
import uz.apphub.metan.ui.navigation.Screen
import uz.apphub.metan.utils.Constants.Companion.EMPTY_STRING

/**
 * Created By Shokirov Begzod on 8/17/2024
 **/
@Composable
fun SignInScreen(
    navController: NavController = rememberNavController(),
    viewModel: SignInViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            TopBarComponent(
                text = "Tizimga kirish",
                onBackClick = {},
                showBackIcon = false
            )
        }
    ) { padding ->

        if (uiState.value.isLoading) {
            LoadingDialogComponent()
        }
        if (uiState.value.errorMessage != null) {
            ErrorDialogComponent(
                message = uiState.value.errorMessage!!
            ) {
                viewModel.displayErrorMessage()
            }
        }

        if(uiState.value.data != null && uiState.value.data == true) {
            navController.popBackStack()
        }

        Column(
            modifier =
            Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {

            Spacer(modifier = Modifier.weight(0.2F))
            TextComponent(
                text = "Assalomu alaykum \n" +
                        "AbiturUz ilovasiga hush kelibsiz"
            )
            Spacer(
                modifier = Modifier
                    .weight(1F, true)
            )
            TextComponent(
                text = "Email manzilini",
            )
            TextFieldComponent(
                value = uiState.value.login,
                placeholder = "Kiriting...",
                onValueChange = { email ->
                    viewModel.changeEmail(email)
                }
            )
            TextComponent(
                text = uiState.value.loginError,
                color = Color.Red
            )
            TextComponent(
                text = "Parol",
            )
            PasswordTextFieldComponent(
                value = uiState.value.password,
                placeholder = "Kiriting...",
                onValueChange = { password ->
                    viewModel.changePassword(password)
                }
            )
            TextComponent(
                text = uiState.value.passwordError,
                color = Color.Red
            )

            Spacer(
                modifier = Modifier
                    .weight(1F, true)
            )
            ButtonComponent(
                text = "Tizimga kirish",
                onClickButton = {
                    viewModel.signIn()
                }
            )
            TextComponent(
                text = "Ro'yxatdan o'tish",
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(
                            Screen.SignUp.email(
                                email = uiState.value.login.ifEmpty { EMPTY_STRING },
                            )
                        )
                    }
            )
        }
    }
}


@Composable
@Preview(showSystemUi = true, showBackground = true)
private fun SignInScreenPreview() {
    SignInScreen()
}