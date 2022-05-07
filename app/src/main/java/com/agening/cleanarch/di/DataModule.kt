package com.agening.cleanarch.di

import com.agening.cleanarch.data.repository.UserRepositoryImpl
import com.agening.cleanarch.data.storage.UserStorage
import com.agening.cleanarch.data.storage.sharedrefs.SharedPrefUserStorage
import com.agening.cleanarch.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}