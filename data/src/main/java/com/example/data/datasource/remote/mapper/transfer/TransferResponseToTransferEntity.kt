package com.example.data.datasource.remote.mapper.transfer

import com.example.data.entity.transfer.TransferResponse
import com.example.data.mapper.Mapper
import com.example.domain.entity.transfer.TransferEntity

class TransferResponseToTransferEntity :
    Mapper<MutableList<TransferResponse>, MutableList<TransferEntity>> {
    override fun map(from: MutableList<TransferResponse>): MutableList<TransferEntity> {
        return from.map {
            TransferEntity(it.clienteId, it.value)
        }.toMutableList()
    }
}