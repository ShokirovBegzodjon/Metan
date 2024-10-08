package uz.apphub.metan.data.remote.request



/**
 * Created By Shokirov Begzod on 10/8/2024
 **/
data class FuelRequest(
    val id: String = "",
    val name: String = "",
    val image: String = "",
    val fuelType: String = "",
    val fuelStatus: String = "",
    val vehicleList: List<VehicleRequest> = listOf()
)