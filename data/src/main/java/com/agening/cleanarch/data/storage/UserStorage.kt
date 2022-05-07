package com.agening.cleanarch.data.storage

import com.agening.cleanarch.data.storage.models.User

interface UserStorage {

    fun save(user: User):Boolean

    fun getName(): User

}