package com.example.desafio.feature.transferhistory.adapter.groupedbyuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.desafio.R
import com.example.desafio.util.toReal
import com.example.domain.entity.transferhistory.TransferHistoryGroupedByUser
import kotlinx.android.synthetic.main.item_chart_transfer_history.view.*

class TransferHistoryGroupedByUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(transferHistoryEntity: TransferHistoryGroupedByUser) {
        Glide.with(itemView.imageViewClient)
            .load(transferHistoryEntity.image)
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.not_photo)
            .apply(RequestOptions.circleCropTransform())
            .into(itemView.imageViewClient)

        itemView.tvValueTotal.text = transferHistoryEntity.value.toReal()
    }

    companion object {
        fun create(parent: ViewGroup): TransferHistoryGroupedByUserViewHolder {
            return TransferHistoryGroupedByUserViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_chart_transfer_history,
                    parent,
                    false
                )
            )
        }
    }
}