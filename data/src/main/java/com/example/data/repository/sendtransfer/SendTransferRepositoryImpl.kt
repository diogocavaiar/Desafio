package com.example.data.repository.sendtransfer

import com.example.data.datasource.local.transfer.repository.SendTransferLocal
import com.example.data.datasource.remote.sendtransfer.SendTransferRemote
import com.example.domain.entity.transfer.TransferEntity
import com.example.domain.repository.sendtransfer.SendTransferRepository
import io.reactivex.Completable
import io.reactivex.Observable


class SendTransferRepositoryImpl(private val remote: SendTransferRemote,
                                 private val local: SendTransferLocal
) : SendTransferRepository {

    override fun sendTransfer(clientId: String, valor: Double): Completable {
        if(isAvailableApi())
            return remote.sendTransfer(clientId, valor)
        else
            return local.sendTransfer(clientId, valor)
    }

    private fun isAvailableApi(): Boolean {
        return false
    }
}