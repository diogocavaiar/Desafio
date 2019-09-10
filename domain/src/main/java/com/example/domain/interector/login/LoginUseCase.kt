package com.example.domain.interector.login

import com.example.domain.entity.login.LoginEntity
import com.example.domain.executor.PostExecutionThread
import com.example.domain.interector.SingleUseCase
import com.example.domain.repository.login.LoginRepository
import io.reactivex.Single

class LoginUseCase(private val repository: LoginRepository,
                   postExecutionThread: PostExecutionThread
) : SingleUseCase<LoginEntity, LoginUseCase.Params>(postExecutionThread){

    override fun buildUseCaseObservable(params: Params?): Single<LoginEntity> {
        if(params == null ||
            params.name.isNullOrEmpty() ||
            params.email.isNullOrEmpty())
            throw IllegalArgumentException("Params can't be null!") as Throwable

        return repository.getLogin(params.name, params.email)
    }

    data class Params(val name: String, val email: String) {
        companion object {
            fun forLogin(name: String, email: String): Params {
                return Params(name, email)
            }
        }
    }
}