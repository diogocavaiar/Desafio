package com.example.domain.repository.transferhistory

import com.example.domain.entity.transferhistory.TransferHistoryEntity
import io.reactivex.Observable

interface TransferHistoryRepository {

    fun getTransferHistory(): Observable<TransferHistoryEntity>

}