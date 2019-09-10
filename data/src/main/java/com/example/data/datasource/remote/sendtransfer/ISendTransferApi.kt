package com.example.data.datasource.remote.sendtransfer

import io.reactivex.Completable

interface ISendTransferApi {

    fun sendTransfer(clientId: String, token: String, valor: Double) : Completable

}