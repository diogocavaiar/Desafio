package com.example.desafio.feature.transferhistory.adapter.byuser

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.transferhistory.TransferHistoryByUser
import com.example.domain.entity.transferhistory.TransferHistoryEntity

class TransferHistoryAdapter : RecyclerView.Adapter<TransferHistoryViewHolder>() {

    private val mListTransferHistory: MutableList<TransferHistoryByUser> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransferHistoryViewHolder {
        return TransferHistoryViewHolder.create(
            parent
        )
    }

    override fun getItemCount(): Int {
        return mListTransferHistory.size
    }

    override fun onBindViewHolder(holder: TransferHistoryViewHolder, position: Int) {
        holder.bind(mListTransferHistory[position])
    }

    fun setListTransferHistory(list: MutableList<TransferHistoryByUser>) {
        mListTransferHistory.addAll(list)
        notifyDataSetChanged()
    }
}