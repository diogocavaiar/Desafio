package com.example.data.datasource.remote.login

import com.example.data.entity.login.LoginResponse
import io.reactivex.Single

interface ILoginApi {
    fun getLogin(name: String, email: String): Single<LoginResponse>
}