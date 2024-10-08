package uz.apphub.metan.data.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.apphub.metan.data.remote.repository.AuthRepository
import uz.apphub.metan.data.remote.repository.HomeRepository
import uz.apphub.metan.data.remote.repositoryimpl.AuthRepositoryImpl
import uz.apphub.metan.data.remote.repositoryimpl.HomeRepositoryImpl

import javax.inject.Singleton

/**
 * Created By Shokirov Begzod on 6/28/2024
 **/
@Module
@InstallIn(SingletonComponent::class)
interface LocalModule {

    @Binds
    @Singleton
    fun bindAuthNetworkRepository(authRepository: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    fun bindHomeNetworkRepository(sciencesRepository: HomeRepositoryImpl): HomeRepository
}

@Module
@InstallIn(SingletonComponent::class)
object FirebaseAuthModule {
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }
}