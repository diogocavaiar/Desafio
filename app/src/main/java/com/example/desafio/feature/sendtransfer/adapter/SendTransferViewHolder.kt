package com.example.desafio.feature.sendtransfer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.desafio.R
import com.example.domain.entity.contact.ContactEntity
import kotlinx.android.synthetic.main.item_send_transfer.view.*

class SendTransferViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(contact: ContactEntity, callback: (contact: ContactEntity) -> Unit) {
        Glide.with(itemView.imageViewClient)
            .load(contact.image)
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.not_photo)
            .apply(RequestOptions.circleCropTransform())
            .into(itemView.imageViewClient)

        itemView.tvName.text = contact.name
        itemView.tvTelephone.text = contact.telephone
        itemView.content.setOnClickListener { callback.invoke(contact) }
    }

    companion object {
        fun create(parent: ViewGroup): SendTransferViewHolder {
            return SendTransferViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_send_transfer,
                    parent,
                    false
                )
            )
        }
    }

}