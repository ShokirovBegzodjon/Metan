package uz.apphub.metan.data.remote.repository

import kotlinx.coroutines.flow.Flow
import uz.apphub.metan.data.model.auth.SignInModel
import uz.apphub.metan.data.model.auth.SignUpModel
import uz.apphub.metan.utils.NetworkResult

/**
 * Created By Shokirov Begzod on 10/8/2024
 **/
interface AuthRepository {

    suspend fun signIn(signInModel: SignInModel): Flow<NetworkResult<Boolean>>

    suspend fun signUp(signUpModel: SignUpModel): Flow<NetworkResult<Boolean>>
}