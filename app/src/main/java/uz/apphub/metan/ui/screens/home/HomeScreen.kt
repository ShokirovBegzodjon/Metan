package uz.apphub.metan.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import uz.apphub.metan.data.model.home.FuelModel
import uz.apphub.metan.data.model.home.FuelStatus
import uz.apphub.metan.data.model.home.FuelType
import uz.apphub.metan.data.model.home.VehicleModel
import uz.apphub.metan.data.model.home.VehicleType
import uz.apphub.metan.ui.components.ButtonComponent
import uz.apphub.metan.ui.components.ErrorDialogComponent
import uz.apphub.metan.ui.components.IconButtonComponent
import uz.apphub.metan.ui.components.LoadingDialogComponent
import uz.apphub.metan.ui.components.TopBarComponent
import uz.apphub.metan.ui.navigation.Screen
import uz.apphub.metan.utils.Constants.Companion.EMPTY_STRING

/**
 * Created By Shokirov Begzod on 8/17/2024
 **/
@Composable
fun HomeScreen(
    navController: NavController = rememberNavController(),
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()
    viewModel.loadScreen()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            TopBarComponent(
                text = uiState.value.user?.name ?: EMPTY_STRING,
                onBackClick = {},
                showBackIcon = false,
                endIcon = Icons.Default.ExitToApp
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
                viewModel.dismissErrorMessage()
            }
        }
        if (uiState.value.user == null) {
            navController.navigate(Screen.SignIn.route)
        }

        Column(
            modifier =
            Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(uiState.value.data) { value ->
                    HomeItem(value)
                }
            }
//            ButtonComponent(
//                text = "saqlash"
//            ) {
//                viewModel.addHomeData(
//                    FuelModel(
//                        id = "0",
//                        image = ".",
//                        name = "Shaffof",
//                        fuelType = FuelType.METHANE,
//                        fuelStatus = FuelStatus.OPEN,
//                        vehicleList = listOf(
//                            VehicleModel(
//                                id = "0",
//                                name = VehicleType.CAR,
//                                count = 5
//                            ),
//                            VehicleModel(
//                                id = "0",
//                                name = VehicleType.BUS,
//                                count = 5
//                            ),
//                            VehicleModel(
//                                id = "0",
//                                name = VehicleType.TRUCK,
//                                count = 5
//                            ),
//                        )
//
//                    )
//                )
//            }
        }

    }
}


@Composable
@Preview(showSystemUi = true, showBackground = true)
private fun SignInScreenPreview() {
    HomeScreen()
}