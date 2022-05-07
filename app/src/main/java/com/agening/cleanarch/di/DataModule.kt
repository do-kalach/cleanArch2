package com.agening.cleanarch.di

import android.content.Context
import android.content.SharedPreferences
import com.agening.cleanarch.data.repository.UserRepositoryImpl
import com.agening.cleanarch.data.storage.UserStorage
import com.agening.cleanarch.data.storage.sharedrefs.SharedPrefUserStorage
import com.agening.cleanarch.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context:Context):UserStorage{
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage):UserRepository{
        return UserRepositoryImpl(userStorage = userStorage)
    }

}