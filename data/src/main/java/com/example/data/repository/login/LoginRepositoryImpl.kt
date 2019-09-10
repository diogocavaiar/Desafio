package com.example.data.repository.login

import com.example.data.datasource.local.login.SessionToken
import com.example.data.datasource.remote.login.LoginRemote
import com.example.domain.entity.login.LoginEntity
import com.example.domain.repository.login.LoginRepository
import io.reactivex.Single

class LoginRepositoryImpl(val remote: LoginRemote,
                          val local: SessionToken) :
    LoginRepository {

    override fun getLogin(name: String, email: String): Single<LoginEntity> {
        return remote.getLogin(name, email)
            .doOnSuccess {
                local.saveToken(it.token)
            }
    }
}