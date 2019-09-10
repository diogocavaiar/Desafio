package com.example.desafio.feature.login

sealed class LoginViewState

object Loading : LoginViewState()
data class Error(val error: String) : LoginViewState()
object Success : LoginViewState()