package com.example.desafio.feature.transferhistory.adapter.groupedbyuser

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.transferhistory.TransferHistoryGroupedByUser

class TransferHistoryGroupedByUserAdapter : RecyclerView.Adapter<TransferHistoryGroupedByUserViewHolder>() {

    private val mListTransferHistoryGroupedByUser: MutableList<TransferHistoryGroupedByUser> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransferHistoryGroupedByUserViewHolder {
        return TransferHistoryGroupedByUserViewHolder.create(
            parent
        )
    }

    override fun getItemCount(): Int {
        return mListTransferHistoryGroupedByUser.size
    }

    override fun onBindViewHolder(holder: TransferHistoryGroupedByUserViewHolder, position: Int) {
        holder.bind(mListTransferHistoryGroupedByUser[position])
    }

    fun setListTransferHistoryGroupedByUser(list: MutableList<TransferHistoryGroupedByUser>) {
        mListTransferHistoryGroupedByUser.addAll(list)
        notifyDataSetChanged()
    }
}