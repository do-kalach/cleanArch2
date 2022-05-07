package com.agening.cleanarch.data.repository

import com.agening.cleanarch.data.storage.UserStorage
import com.agening.cleanarch.data.storage.models.User
import com.agening.cleanarch.domain.models.SaveUserNameParam
import com.agening.cleanarch.domain.models.UserName
import com.agening.cleanarch.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.getName()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(saveParam.name, "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(user.firstName, user.lastName)
    }

}