package com.example.desafio.feature.sendtransfer.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafio.feature.sendtransfer.view.viewstate.*
import com.example.domain.entity.contact.ContactEntity
import com.example.domain.interector.CompletableUseCase
import com.example.domain.interector.ObservableUseCase
import com.example.domain.interector.transfer.SendTransferUseCase

class SendTransferViewModel(private val contactsUseCase: ObservableUseCase<MutableList<ContactEntity>, Nothing>,
                            private val sendTranferUseCase: CompletableUseCase<SendTransferUseCase.Params>) : ViewModel() {

    private val viewStateContacts: MutableLiveData<ViewStateContacts> = MutableLiveData()
    private val viewStateSendTransfer: MutableLiveData<ViewStateSendTransfer> = MutableLiveData()

    init {
        contactsUseCase.execute(doOnSubscribe = {
            viewStateContacts.postValue(ViewStateContacts.Loading)
        }, onSuccess = {
            viewStateContacts.postValue(ViewStateContacts.Success(it))
        }, onError = {
            viewStateContacts.postValue(ViewStateContacts.Error(it.message!!))
        })
    }

    fun getStateContacts(): MutableLiveData<ViewStateContacts> {
        return viewStateContacts
    }

    fun getStateSendTransfer(): MutableLiveData<ViewStateSendTransfer> {
        return viewStateSendTransfer
    }

    fun sendTranferToContact(clientId: String, valor: Double) {
        sendTranferUseCase.execute(SendTransferUseCase.Params.forSendTransfer(clientId, valor), {}, {
            viewStateSendTransfer.postValue(ViewStateSendTransfer.Success(true))
        }, {
            viewStateSendTransfer.postValue(ViewStateSendTransfer.Error(it.message!!))
        })
    }
}