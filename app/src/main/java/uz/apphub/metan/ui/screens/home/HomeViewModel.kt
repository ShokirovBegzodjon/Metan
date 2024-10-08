package uz.apphub.metan.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uz.apphub.metan.data.model.home.FuelModel
import uz.apphub.metan.data.remote.repository.HomeRepository
import uz.apphub.metan.utils.Status
import javax.inject.Inject

/**
 * Created By Shokirov Begzod on 8/20/2024
 **/
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState = _uiState.asStateFlow()
    private val TAG = "SignInView"

    fun loadScreen() {
        viewModelScope.launch {
            val user = homeRepository.currentUser()
            if (user == null) {
                _uiState.value = _uiState.value.copy(
                    errorMessage = "User not found",
                    user = null
                )
            } else {
                _uiState.value = _uiState.value.copy(user = user)
                getHomeData()
            }
        }
    }

    private fun getHomeData(){
        viewModelScope.launch {
            homeRepository.getHomeData().collect {
                with(it) {
                    Log.d(TAG, it.toString())
                    when (status) {
                        Status.LOADING -> {
                            _uiState.value = _uiState.value.copy(isLoading = true)
                        }

                        Status.SUCCESS -> {
                            if (it.data != null) {
                                _uiState.value = _uiState.value.copy(data = it.data, isLoading = false)
                            } else {
                                _uiState.value = _uiState.value.copy(errorMessage = "Ma'lumot topilmadi", isLoading = false)
                            }
                            Log.d(TAG, "HomeScreen: ${uiState.value.data}")
                        }

                        Status.ERROR -> {
                            _uiState.value =
                                _uiState.value.copy(errorMessage = it.message, isLoading = false)
                        }

                        Status.EMPTY -> {}
                    }
                }
            }
        }
    }

    fun addHomeData(fuelModel: FuelModel){
        viewModelScope.launch {
            homeRepository.addHomeData(fuelModel).collect {
                with(it) {
                    Log.d(TAG, it.toString())
                    when (status) {
                        Status.LOADING -> {
                            _uiState.value = _uiState.value.copy(isLoading = true)
                        }

                        Status.SUCCESS -> {
                            if (it.data == true) {
                                getHomeData()
                            } else {
                                _uiState.value = _uiState.value.copy(errorMessage = "Saqlanmadi", isLoading = false)
                            }
                            Log.d(TAG, "HomeScreen: ${uiState.value.data}")
                        }

                        Status.ERROR -> {
                            _uiState.value =
                                _uiState.value.copy(errorMessage = it.message, isLoading = false)
                        }

                        Status.EMPTY -> {}
                    }
                }
            }
        }
    }

    fun dismissErrorMessage() {
        _uiState.value = _uiState.value.copy(errorMessage = null)
    }

    fun logOut() {
        homeRepository.logOut()
        _uiState.value = _uiState.value.copy(user = null)
    }
}