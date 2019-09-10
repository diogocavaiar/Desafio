package com.example.data.datasource.local.login

import java.util.prefs.AbstractPreferences

class SessionTokenImpl(val preferences: AbstractPreferences) : SessionToken {

    override fun saveToken(token: String) {
        preferences.put(TOKEN, token)
    }

    override fun getToken(): String {
        return preferences.get(TOKEN, "")
    }

    companion object {
        private const val TOKEN = "token"
    }

}