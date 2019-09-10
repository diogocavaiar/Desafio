package com.example.data.datasource.remote.login

import com.example.domain.entity.login.LoginEntity
import io.reactivex.Single

interface LoginRemote {

    fun getLogin(name: String, email: String): Single<LoginEntity>

}