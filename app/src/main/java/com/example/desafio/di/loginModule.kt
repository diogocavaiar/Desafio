package com.example.desafio.di

import com.example.data.datasource.local.login.SessionToken
import com.example.data.datasource.local.login.SessionTokenImpl
import com.example.data.datasource.remote.login.ILoginApi
import com.example.data.datasource.remote.login.LoginApi
import com.example.data.datasource.remote.login.LoginRemote
import com.example.data.datasource.remote.login.LoginRemoteImpl
import com.example.data.entity.login.LoginResponse
import com.example.data.mapper.Mapper
import com.example.data.datasource.remote.mapper.login.LoginMapper
import com.example.data.repository.login.LoginRepositoryImpl
import com.example.desafio.feature.login.LoginViewModel
import com.example.domain.entity.login.LoginEntity
import com.example.domain.interector.SingleUseCase
import com.example.domain.interector.login.LoginUseCase
import com.example.domain.repository.login.LoginRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mLoginModule = module {

    single<SingleUseCase<LoginEntity, LoginUseCase.Params>>(named(LOGIN_USE_CASE)) {
        LoginUseCase(
            get(named(LOGIN_REPOSITORY)),
            get(named(NEW_THREAD))
        )
    }

    single<LoginRepository>(named(LOGIN_REPOSITORY)) {
        LoginRepositoryImpl(
            get(named(LOGIN_REMOTE)),
            get(named(SESSION))
        )
    }

    single<LoginRemote>(named(LOGIN_REMOTE)) {
        LoginRemoteImpl(
            get(named(LOGIN_API)),
            get(named(LOGIN_MAPPER))
        )
    }

    single<ILoginApi>(named(LOGIN_API)) {
        LoginApi()
    }

    single<Mapper<LoginResponse, LoginEntity>>(named(LOGIN_MAPPER)) {
        LoginMapper()
    }

    single<SessionToken>(named(SESSION)) {
        SessionTokenImpl(get(named(PREFERENCES)))
    }

    viewModel {
        LoginViewModel(get(named(LOGIN_USE_CASE)))
    }
}

private const val LOGIN_USE_CASE = "login_use_case"
private const val LOGIN_REPOSITORY = "login_repository"
private const val LOGIN_REMOTE = "login_remote"
private const val LOGIN_API = "login_api"
private const val LOGIN_MAPPER = "login_mapper"
const val SESSION = "session"