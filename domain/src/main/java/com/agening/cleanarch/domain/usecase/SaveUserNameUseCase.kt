package com.agening.cleanarch.domain.usecase

import com.agening.cleanarch.domain.models.SaveUserNameParam
import com.agening.cleanarch.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean {
        val result = userRepository.saveName(param)
        return !param.name.isEmpty()
    }
}