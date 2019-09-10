package com.example.data.datasource.local.login

interface SessionToken {

    fun saveToken(token: String)

    fun getToken(): String

}