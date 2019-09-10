package com.example.data.datasource.remote.sendtransfer

import com.example.data.datasource.local.login.SessionToken
import io.reactivex.Completable

class SendTransferRemoteImpl(val sendTransferApi: ISendTransferApi,
                             val session: SessionToken) : SendTransferRemote {

    override fun sendTransfer(clientId: String, valor: Double): Completable {
        return sendTransferApi.sendTransfer(clientId, session.getToken(), valor)
    }
}