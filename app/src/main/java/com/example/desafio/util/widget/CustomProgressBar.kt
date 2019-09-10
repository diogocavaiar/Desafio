package com.example.desafio.util.widget

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.desafio.R
import com.example.desafio.feature.base.BaseDialog

class CustomProgressBar(val context: Context) : BaseDialog() {

    override val dialogView: View by lazy {
        LayoutInflater.from(context).inflate(R.layout.custom_progress_bar, null)
    }

    override val builder: AlertDialog.Builder = AlertDialog.Builder(context).setView(dialogView)

}