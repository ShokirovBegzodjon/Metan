package uz.apphub.metan.data.remote.repository

import kotlinx.coroutines.flow.Flow
import uz.apphub.metan.data.model.home.FuelModel
import uz.apphub.metan.data.model.home.UserMode
import uz.apphub.metan.utils.NetworkResult

/**
 * Created By Shokirov Begzod on 10/8/2024
 **/
interface HomeRepository {
    suspend fun getHomeData(): Flow<NetworkResult<List<FuelModel>>>
    suspend fun currentUser(): UserMode?
    suspend fun addHomeData(fuelModel: FuelModel): Flow<NetworkResult<Boolean>>
    fun logOut()
}