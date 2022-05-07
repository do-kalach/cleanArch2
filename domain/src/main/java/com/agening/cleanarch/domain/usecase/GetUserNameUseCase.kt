package com.agening.cleanarch.domain.usecase

import com.agening.cleanarch.domain.models.UserName
import com.agening.cleanarch.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute():UserName{
        return userRepository.getName()
    }
}