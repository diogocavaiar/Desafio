package com.example.domain.repository.login

import com.example.domain.entity.login.LoginEntity
import io.reactivex.Single

interface LoginRepository {

    fun getLogin(name: String, email: String): Single<LoginEntity>

}