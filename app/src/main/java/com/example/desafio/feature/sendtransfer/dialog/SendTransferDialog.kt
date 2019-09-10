package com.example.desafio.feature.sendtransfer.dialog

import android.content.Context
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.desafio.R
import com.example.desafio.feature.base.BaseDialog
import com.example.desafio.util.collapseDialog
import com.example.desafio.util.show
import com.example.desafio.util.showDialog
import com.example.desafio.util.showToast
import com.example.desafio.util.widget.CustomProgressBar
import com.example.domain.entity.contact.ContactEntity
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.alert_send_transfer_to_contact.view.*

class SendTransferDialog(val context: Context, val contact: ContactEntity, val func: (value: Double) -> Unit) : BaseDialog() {

    private val customProgressBar: CustomProgressBar by lazy {
        CustomProgressBar(context)
    }

    override val dialogView: View by lazy {
        LayoutInflater.from(context).inflate(R.layout.alert_send_transfer_to_contact, null)
    }

    override val builder: AlertDialog.Builder = AlertDialog.Builder(context).setView(dialogView)

    override var cancelable: Boolean = false

    init {
        val edtValue = dialogView.findViewById<AppCompatEditText>(R.id.edtValue)
        dialogView.findViewById<AppCompatImageButton>(R.id.imageViewClose).apply {
            setOnClickListener { dialog?.dismiss() }
        }
        dialogView.findViewById<CircleImageView>(R.id.imageViewClient).apply {
            Glide.with(this)
                .load(contact.image)
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.not_photo)
                .apply(RequestOptions.circleCropTransform())
                .into(this)
        }
        dialogView.findViewById<AppCompatTextView>(R.id.tvName).apply {
            text = contact.name
        }
        dialogView.findViewById<AppCompatTextView>(R.id.tvTelephone).apply {
            text = contact.telephone
        }
        dialogView.findViewById<AppCompatButton>(R.id.btnSendTransfer).apply {
            setOnClickListener {
                val valueString = edtValue.text.toString()
                val value = (if(valueString.isEmpty()) "0" else valueString).toDouble()

                if(value <= 0) {
                    showToast(context, context.getString(R.string.value_is_invalid))
                    return@setOnClickListener
                }

                showDialog(customProgressBar.create())
                Handler().postDelayed(
                    {
                        collapseDialog(customProgressBar.dialog!!)
                        dialog!!.dismiss()
                        func.invoke(value)
                    },
                    3000 // value in milliseconds
                )
            }
        }
    }

}