package uz.apphub.metan.data.model.home

import uz.apphub.metan.data.remote.request.FuelRequest

/**
 * Created By Shokirov Begzod on 10/8/2024
 **/
data class FuelModel(
    val id: String = "",
    val name: String = "",
    val image: String = "",
    val fuelType: FuelType = FuelType.OTHER,
    val fuelStatus: FuelStatus = FuelStatus.OTHER,
    val vehicleList: List<VehicleModel> = listOf()
)

fun FuelModel.toRequest() = FuelRequest(
    id = id,
    name = name,
    image = image,
    fuelType = fuelType.name,
    fuelStatus = fuelStatus.name,
    vehicleList = vehicleList.map { it.toRequest() }
)