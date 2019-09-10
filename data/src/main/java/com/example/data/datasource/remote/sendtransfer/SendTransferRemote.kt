package com.example.data.datasource.remote.sendtransfer

import io.reactivex.Completable

interface SendTransferRemote {

    fun sendTransfer(clientId: String, valor: Double) : Completable

}