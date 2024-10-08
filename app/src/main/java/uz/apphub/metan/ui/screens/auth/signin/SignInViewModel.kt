package uz.apphub.metan.ui.screens.auth.signin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uz.apphub.metan.data.model.auth.SignInModel
import uz.apphub.metan.data.remote.repository.AuthRepository
import uz.apphub.metan.utils.Status
import javax.inject.Inject

/**
 * Created By Shokirov Begzod on 8/20/2024
 **/
@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authRepository: AuthRepository,
):ViewModel() {
    private val _uiState = MutableStateFlow(SignInScreenUiState())
    val uiState = _uiState.asStateFlow()
    private val TAG = "SignInView"

    fun signIn(){
        viewModelScope.launch {
            if (uiState.value.login.isEmpty()){
                _uiState.value = _uiState.value.copy(loginError = "Email manzilini kiriting")
                return@launch
            } else if (uiState.value.password.isEmpty()){
                _uiState.value = _uiState.value.copy(passwordError = "Parol kiriting")
                return@launch
            } else if (uiState.value.password.length < 8){
                _uiState.value = _uiState.value.copy(passwordError = "Kamida 8 ta belgidan iborat boʻlishi kerak.")
                return@launch
            } else {
                authRepository.signIn(
                    SignInModel(
                        email = uiState.value.login,
                        password = uiState.value.password
                    )
                ).collect {
                    with(it) {
                        Log.d(TAG, it.toString())
                        when (status) {
                            Status.LOADING -> {
                                _uiState.value = _uiState.value.copy(isLoading = true)
                            }

                            Status.SUCCESS -> {
                                _uiState.value = _uiState.value.copy(data = it.data, isLoading = false)
                            }

                            Status.ERROR -> {
                                _uiState.value = _uiState.value.copy(errorMessage = it.message, isLoading = false)
                            }
                            Status.EMPTY -> {}
                        }
                    }
                }
            }
        }
    }

    fun changePassword(password: String) {
        _uiState.value = _uiState.value.copy(
            password = password,
            passwordError = ""
        )
    }

    fun changeEmail(email: String) {
        _uiState.value = _uiState.value.copy(
            login = email,
            loginError = ""
        )
    }

    fun displayErrorMessage() {
        _uiState.value = _uiState.value.copy(errorMessage = null)
    }

}