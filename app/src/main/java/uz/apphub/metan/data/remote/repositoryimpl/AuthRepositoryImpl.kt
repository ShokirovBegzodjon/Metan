package uz.apphub.metan.data.remote.repositoryimpl

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.tasks.await
import uz.apphub.metan.data.model.auth.SignInModel
import uz.apphub.metan.data.model.auth.SignUpModel
import uz.apphub.metan.data.remote.repository.AuthRepository
import uz.apphub.metan.utils.NetworkResult
import javax.inject.Inject


/**
 * Created By Shokirov Begzod on 10/8/2024
 **/
class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {
    override suspend fun signIn(signInModel: SignInModel): Flow<NetworkResult<Boolean>> = flow<NetworkResult<Boolean>> {
        emit(NetworkResult.loading())
        val authResponse = auth.signInWithEmailAndPassword(
            signInModel.email,
            signInModel.password
        ).await()
        if (authResponse.user != null) {
            emit(NetworkResult.success(true))
        } else {
            emit(NetworkResult.error("Foydalanuvchi mavjud emas \n Ro'yxatdan o'ting"))
        }
    }.catch { e ->
        emit(NetworkResult.error(e.localizedMessage?: "Some error in flow"))
    }

    override suspend fun signUp(signUpModel: SignUpModel): Flow<NetworkResult<Boolean>> = flow<NetworkResult<Boolean>> {
        emit(NetworkResult.loading())
        val authResponse = auth.createUserWithEmailAndPassword(
            signUpModel.email,
            signUpModel.password
        ).await()
        if (authResponse.user != null) {
            emit(NetworkResult.success(true))
        } else {
            emit(NetworkResult.error("Foydalanuvchi mavjud"))
        }
    }.catch { e ->
        emit(NetworkResult.error(e.localizedMessage?: "Some error in flow"))
    }
}