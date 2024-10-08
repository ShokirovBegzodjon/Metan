package uz.apphub.metan.data.remote.response

import uz.apphub.metan.data.model.home.VehicleModel
import uz.apphub.metan.data.model.home.VehicleType

/**
 * Created By Shokirov Begzod on 10/8/2024
 **/
data class VehicleResponse(
    val id: String = "",
    val name: String = "",
    val count: Int = 0,
)

fun VehicleResponse.toModel() = VehicleModel(
    id = id,
    name = when (name) {
        VehicleType.CAR.name -> VehicleType.CAR
        VehicleType.BUS.name -> VehicleType.BUS
        VehicleType.TRUCK.name -> VehicleType.TRUCK
        else -> VehicleType.OTHERS
    },
    count = count,
)
