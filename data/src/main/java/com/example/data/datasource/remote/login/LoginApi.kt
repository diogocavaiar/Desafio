package com.example.data.datasource.remote.login

import com.example.data.entity.login.LoginResponse
import io.reactivex.Single
import java.util.*

class LoginApi : ILoginApi {

    override fun getLogin(name: String, email: String): Single<LoginResponse> {
        return Single.just(LoginResponse(UUID.randomUUID().toString()))
    }

}