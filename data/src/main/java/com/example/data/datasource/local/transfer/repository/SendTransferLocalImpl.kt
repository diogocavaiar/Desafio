package com.example.data.datasource.local.transfer.repository

import com.example.data.datasource.local.login.SessionToken
import com.example.data.datasource.local.transfer.dao.TransferDao
import com.example.data.datasource.local.transfer.entity.Transfer
import io.reactivex.Completable

class SendTransferLocalImpl(private val session: SessionToken,
                            private val transferDao: TransferDao
) : SendTransferLocal {

    override fun sendTransfer(clientId: String, value: Double) : Completable {
        return transferDao.sendTransfer(Transfer(clientId, session.getToken(), value))
    }

}