package com.example.data.datasource.remote.login

import com.example.data.entity.login.LoginResponse
import com.example.data.mapper.Mapper
import com.example.domain.entity.login.LoginEntity
import io.reactivex.Single

class LoginRemoteImpl(val api: ILoginApi,
                      val mapper: Mapper<LoginResponse, LoginEntity>
) : LoginRemote {

    override fun getLogin(name: String, email: String): Single<LoginEntity> {
        return api.getLogin(name, email)
            .map {
                mapper.map(it)
            }
    }
}