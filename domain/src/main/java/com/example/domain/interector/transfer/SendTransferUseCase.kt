package com.example.domain.interector.transfer

import com.example.domain.executor.PostExecutionThread
import com.example.domain.interector.CompletableUseCase
import com.example.domain.repository.sendtransfer.SendTransferRepository
import io.reactivex.Completable
import java.lang.IllegalArgumentException

class SendTransferUseCase(val repository: SendTransferRepository,
                          postExecutionThread: PostExecutionThread) : CompletableUseCase<SendTransferUseCase.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Completable {
        if(params == null ||
                params.clientId.isNullOrEmpty() ||
                params.valor <= 0) throw IllegalArgumentException("Todos os parâmetros devem ser válidos!")

        return repository.sendTransfer(params.clientId, params.valor)
    }


    data class Params(val clientId: String, val valor: Double) {
        companion object {
            fun forSendTransfer(clientId: String, valor: Double): Params {
                return Params(clientId, valor)
            }
        }
    }

}