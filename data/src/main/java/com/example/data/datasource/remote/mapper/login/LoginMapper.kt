package com.example.data.datasource.remote.mapper.login

import com.example.data.entity.login.LoginResponse
import com.example.data.mapper.Mapper
import com.example.domain.entity.login.LoginEntity

class LoginMapper : Mapper<LoginResponse, LoginEntity> {
    override fun map(from: LoginResponse): LoginEntity {
        return LoginEntity(from.token)
    }
}