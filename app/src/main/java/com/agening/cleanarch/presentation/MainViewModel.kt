package com.agening.cleanarch.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agening.cleanarch.data.repository.UserRepositoryImpl
import com.agening.cleanarch.data.storage.sharedrefs.SharedPrefUserStorage
import com.agening.cleanarch.domain.models.SaveUserNameParam
import com.agening.cleanarch.domain.models.UserName
import com.agening.cleanarch.domain.usecase.GetUserNameUseCase
import com.agening.cleanarch.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
): ViewModel() {

//    private val userRepository by lazy { UserRepositoryImpl(SharedPrefUserStorage(context = applicationContext)) }
//    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
//    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }

    val resultLive = MutableLiveData<String>()

    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared: ", )
        super.onCleared()
    }

    fun save(text:String){
        val params = SaveUserNameParam(name = text)
        val result = saveUserNameUseCase.execute(param = params)
        resultLive.value =  "Save result = $result"
    }

    fun load(){
        val userName: UserName = getUserNameUseCase.execute()
        resultLive.value = "${userName.firstName} ${userName.lastName}"
    }

}