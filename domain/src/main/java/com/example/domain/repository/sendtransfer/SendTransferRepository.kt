package com.example.domain.repository.sendtransfer

import io.reactivex.Completable

interface SendTransferRepository {

    fun sendTransfer(clientId: String, valor: Double) : Completable

}