package com.example.data.datasource.local.mapper

import com.example.data.datasource.local.transfer.entity.Transfer
import com.example.data.mapper.Mapper
import com.example.domain.entity.transfer.TransferEntity

class TransferToTransferEntityMapper : Mapper<MutableList<Transfer>, MutableList<TransferEntity>> {
    override fun map(from: MutableList<Transfer>): MutableList<TransferEntity> {
        return from.map {
            TransferEntity(it.clientId, it.value)
        }.toMutableList()
    }
}