package com.example.desafio.feature.transferhistory.adapter.byuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.desafio.R
import com.example.desafio.util.toReal
import com.example.domain.entity.transferhistory.TransferHistoryByUser
import com.example.domain.entity.transferhistory.TransferHistoryEntity
import kotlinx.android.synthetic.main.item_transfer_history.view.*

class TransferHistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(transferHistoryEntity: TransferHistoryByUser) {
        Glide.with(itemView.imageViewClient)
            .load(transferHistoryEntity.image)
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.not_photo)
            .apply(RequestOptions.circleCropTransform())
            .into(itemView.imageViewClient)

        itemView.tvName.text = transferHistoryEntity.name
        itemView.tvTelephone.text = transferHistoryEntity.telephone
        itemView.tvValue.text = transferHistoryEntity.value.toReal()
    }

    companion object {
        fun create(parent: ViewGroup): TransferHistoryViewHolder {
            return TransferHistoryViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_transfer_history,
                    parent,
                    false
                )
            )
        }
    }
}