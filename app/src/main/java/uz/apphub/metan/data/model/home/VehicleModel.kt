package uz.apphub.metan.data.model.home

import uz.apphub.metan.data.remote.request.VehicleRequest

/**
 * Created By Shokirov Begzod on 10/8/2024
 **/
data class VehicleModel(
 val id: String = "",
 val name: VehicleType = VehicleType.OTHERS,
 val count: Int = 0,
)

fun VehicleModel.toRequest() = VehicleRequest(
 id = id,
 name = name.name,
 count = count,
)
