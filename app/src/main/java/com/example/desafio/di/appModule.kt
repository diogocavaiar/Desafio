package com.example.desafio.di

import androidx.room.Room
import com.example.data.datasource.local.AppDatabase
import com.example.desafio.UiThread
import com.example.domain.executor.PostExecutionThread
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.util.prefs.Preferences

val mDatabase = module {
    single(named(APP_DATABASE)) {
        Room.databaseBuilder(get(), AppDatabase::class.java, "desafio.db").build()
    }
}

val mThreads = module {
    factory<PostExecutionThread>(named(NEW_THREAD)) { UiThread() }
}

val mSheredPreferences = module {
    single(named(PREFERENCES)) { provideSettingsPreferences() }
}

private fun provideSettingsPreferences(): Preferences = Preferences.userRoot()

const val PREFERENCES = "sahred_preferences"
const val NEW_THREAD = "new_thread"
const val APP_DATABASE = "app_database"