package com.example.data.repository.transferhistory

import com.example.data.datasource.local.transferhistory.repository.TransferHistoryLocal
import com.example.domain.entity.transferhistory.TransferHistoryEntity
import com.example.domain.repository.transferhistory.TransferHistoryRepository
import io.reactivex.Observable

class TransferHistoryRepositoryImpl(private val local : TransferHistoryLocal) : TransferHistoryRepository {

    override fun getTransferHistory(): Observable<TransferHistoryEntity> {
        return local.getTransferHistory()
    }

}