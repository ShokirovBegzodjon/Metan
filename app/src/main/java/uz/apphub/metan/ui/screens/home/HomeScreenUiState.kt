package uz.apphub.metan.ui.screens.home

import uz.apphub.metan.data.model.home.FuelModel
import uz.apphub.metan.data.model.home.UserMode

/**
 * Created By Shokirov Begzod on 8/20/2024
 **/
data class HomeScreenUiState(
    val data: List<FuelModel> = emptyList(),
    val user: UserMode? = UserMode(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)
