package com.example.desafio.feature.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entity.login.LoginEntity
import com.example.domain.interector.SingleUseCase
import com.example.domain.interector.login.LoginUseCase

class LoginViewModel(val useCase: SingleUseCase<LoginEntity, LoginUseCase.Params>) : ViewModel() {

    private val viewState: MutableLiveData<LoginViewState> = MutableLiveData()

    fun loadLogin(name: String, email: String) {
        useCase.execute(LoginUseCase.Params.forLogin(name, email), {
            viewState.postValue(Loading)
        }, {
            if(it.token.isNotEmpty())
                viewState.postValue(Success)
        }, {
            viewState.postValue(Error(it.message!!))
        })
    }

    fun getStateLogin() : MutableLiveData<LoginViewState> {
        return viewState
    }

}