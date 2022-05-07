package com.agening.cleanarch.di

import com.agening.cleanarch.domain.usecase.GetUserNameUseCase
import com.agening.cleanarch.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

}