package uz.apphub.metan.data.remote.repositoryimpl

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import uz.apphub.metan.data.model.home.FuelModel
import uz.apphub.metan.data.model.home.UserMode
import uz.apphub.metan.data.model.home.toRequest
import uz.apphub.metan.data.remote.repository.HomeRepository
import uz.apphub.metan.data.remote.response.FuelResponse
import uz.apphub.metan.data.remote.response.toModel
import uz.apphub.metan.utils.Constants.Companion.BASE_URL
import uz.apphub.metan.utils.Constants.Companion.EMPTY_STRING
import uz.apphub.metan.utils.NetworkResult
import javax.inject.Inject

/**
 * Created By Shokirov Begzod on 10/8/2024
 **/
class HomeRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth
) : HomeRepository {

    private val userRef = firestore.collection(BASE_URL).document("home").collection("data")
    private val TAG = "HomeRepository"

    override suspend fun getHomeData(): Flow<NetworkResult<List<FuelModel>>> = flow {
        emit(NetworkResult.loading())

        val documentData = mutableListOf<FuelModel>()

        try {
            val querySnapshot = userRef.get().await()
            Log.e(TAG, "$userRef user ref")

            for (document in querySnapshot) {
                var newDocument = document.toObject(FuelResponse::class.java)
                newDocument = newDocument.copy(id = document.id)
                documentData.add(newDocument.toModel())
            }
            emit(NetworkResult.success(documentData))
        } catch (e: Exception) {
            emit(NetworkResult.error(e.message))
            Log.e(TAG, "get user error $e")
        }

    }.catch { e ->
        emit(NetworkResult.error(e.localizedMessage ?: "Some error in flow"))
    }

    override suspend fun addHomeData(fuelModel: FuelModel): Flow<NetworkResult<Boolean>> = flow {
        emit(NetworkResult.loading())

        try {
            userRef.add(fuelModel.toRequest()).await()
            Log.d(TAG, "insert attend succeeded $fuelModel")
            emit(NetworkResult.success(true))
        } catch (e: Exception) {
            emit(NetworkResult.error(e.message))
            Log.e(TAG, "insert attend error $e")
        }
    }.catch { e ->
        emit(NetworkResult.error(e.localizedMessage ?: "Some error in flow"))
    }

    override fun logOut() {
        auth.signOut()
    }

    override suspend fun currentUser(): UserMode? {
        val user = auth.currentUser
        return if (user == null) {
            null
        } else {
            UserMode(
                user.uid,
                user.email ?: user.displayName ?: EMPTY_STRING,
            )
        }
    }
}