package com.example.desafio.util

import android.app.Activity
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

fun showDialog(dialog: AlertDialog?) {
    if(dialog?.isShowing == false)
        dialog.show()
}

fun collapseDialog(dialog: AlertDialog?) {
    if(dialog?.isShowing == true)
        dialog.dismiss()
}

fun Activity.showMessageWithSnackBar(view: View = findViewById(android.R.id.content), message: String, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(view, message, duration).show()
}
