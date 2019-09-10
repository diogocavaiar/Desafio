package com.example.desafio

import android.app.Application
import com.example.desafio.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(mDatabase, mThreads, mSheredPreferences, mLoginModule, mContactModule, mSendTransferModule, mTransfershistory))
        }
    }

}