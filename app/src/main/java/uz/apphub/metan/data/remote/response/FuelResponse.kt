package uz.apphub.metan.data.remote.response

import uz.apphub.metan.data.model.home.FuelModel
import uz.apphub.metan.data.model.home.FuelStatus
import uz.apphub.metan.data.model.home.FuelType

/**
 * Created By Shokirov Begzod on 10/8/2024
 **/
data class FuelResponse(
    val id: String = "",
    val name: String = "",
    val image: String = "",
    val fuelType: String = "",
    val fuelStatus: String = "",
    val vehicleList: List<VehicleResponse> = listOf()
)

fun FuelResponse.toModel() = FuelModel(
    id = id,
    name = name,
    image = image,
    fuelType = when (fuelType) {
        FuelType.METHANE.name -> FuelType.METHANE
        FuelType.PROPANE.name -> FuelType.PROPANE
        FuelType.GASOLINE.name -> FuelType.GASOLINE
        FuelType.DIESEL.name -> FuelType.DIESEL
        else -> FuelType.OTHER
    },
    fuelStatus = when (fuelStatus) {
        FuelStatus.OPEN.name -> FuelStatus.OPEN
        FuelStatus.CLOSED.name -> FuelStatus.CLOSED
        else -> FuelStatus.OTHER
    },
    vehicleList = vehicleList.map { it.toModel() }
)