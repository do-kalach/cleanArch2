package com.agening.cleanarch.domain.repository

import com.agening.cleanarch.domain.models.SaveUserNameParam
import com.agening.cleanarch.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam):Boolean

    fun getName(): UserName

}