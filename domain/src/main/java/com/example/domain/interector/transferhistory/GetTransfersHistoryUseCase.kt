package com.example.domain.interector.transferhistory

import com.example.domain.entity.transferhistory.TransferHistoryEntity
import com.example.domain.executor.PostExecutionThread
import com.example.domain.interector.ObservableUseCase
import com.example.domain.repository.transferhistory.TransferHistoryRepository
import io.reactivex.Observable

class GetTransfersHistoryUseCase(private val repository: TransferHistoryRepository,
                                 private val postExecutionThread: PostExecutionThread):
    ObservableUseCase<TransferHistoryEntity, Nothing>(postExecutionThread){

    override fun buildUseCaseObservable(params: Nothing?): Observable<TransferHistoryEntity> {
        return repository.getTransferHistory()
    }
}