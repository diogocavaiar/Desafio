package com.example.desafio.feature.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        initValues()
        initObserver()
    }

    @LayoutRes
    abstract fun getLayoutRes(): Int

    abstract fun initValues()

    abstract fun initObserver()
}