package com.example.desafio.feature.transferhistory.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafio.feature.transferhistory.view.viewstate.Error
import com.example.desafio.feature.transferhistory.view.viewstate.Success
import com.example.desafio.feature.transferhistory.view.viewstate.TransferHistoryViewState
import com.example.domain.entity.transferhistory.TransferHistoryEntity
import com.example.domain.interector.ObservableUseCase

class TransferHistoryViewModel(private val getTransfersHistoryUseCase: ObservableUseCase<TransferHistoryEntity, Nothing>) : ViewModel() {

    private val state: MutableLiveData<TransferHistoryViewState> = MutableLiveData()

    init {
        getTransfersHistoryUseCase.execute(doOnSubscribe = {

        }, onSuccess = {
            state.postValue(Success(it))
        }, onError =  {
            state.postValue(Error(it.message!!))
        })
    }

    fun getState(): MutableLiveData<TransferHistoryViewState> {
        return state
    }
}