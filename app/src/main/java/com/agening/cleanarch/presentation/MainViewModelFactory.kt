package com.agening.cleanarch.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agening.cleanarch.data.repository.UserRepositoryImpl
import com.agening.cleanarch.data.storage.sharedrefs.SharedPrefUserStorage
import com.agening.cleanarch.domain.usecase.GetUserNameUseCase
import com.agening.cleanarch.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context:Context): ViewModelProvider.Factory {

    private val userRepository by lazy { UserRepositoryImpl(SharedPrefUserStorage(context = context)) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}