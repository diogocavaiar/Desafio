package com.example.data.datasource.local.transferhistory.repository

import com.example.domain.entity.transferhistory.TransferHistoryEntity
import io.reactivex.Observable

interface TransferHistoryLocal {

    fun getTransferHistory(): Observable<TransferHistoryEntity>

}