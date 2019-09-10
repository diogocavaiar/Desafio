package com.example.data.datasource.local.transfer.repository

import io.reactivex.Completable

interface SendTransferLocal {

    fun sendTransfer(clientId: String, value: Double) : Completable

}