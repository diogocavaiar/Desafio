package com.example.desafio.feature.sendtransfer.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.contact.ContactEntity

class SendTransferAdapter(val callback: (contact: ContactEntity) -> Unit): RecyclerView.Adapter<SendTransferViewHolder>() {

    private val mListContact: MutableList<ContactEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SendTransferViewHolder {
        return SendTransferViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return mListContact.size
    }

    override fun onBindViewHolder(holder: SendTransferViewHolder, position: Int) {
        holder.bind(mListContact[position], callback)
    }

    fun setListContact(list: MutableList<ContactEntity>) {
        mListContact.addAll(list)
        notifyDataSetChanged()
    }
}