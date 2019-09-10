package com.example.data.datasource.remote.sendtransfer

import io.reactivex.Completable

class SendTransferApi : ISendTransferApi {

    override fun sendTransfer(clientId: String, token: String, valor: Double): Completable {
        return Completable.complete()
    }

}