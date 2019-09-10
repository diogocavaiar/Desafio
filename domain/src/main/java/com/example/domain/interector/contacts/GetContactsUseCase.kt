package com.example.domain.interector.contacts

import com.example.domain.entity.contact.ContactEntity
import com.example.domain.executor.PostExecutionThread
import com.example.domain.interector.ObservableUseCase
import com.example.domain.repository.contact.ContactRepository
import com.example.domain.repository.sendtransfer.SendTransferRepository
import io.reactivex.Observable

class GetContactsUseCase(val repository: ContactRepository,
                         postExecutionThread: PostExecutionThread) :
    ObservableUseCase<MutableList<ContactEntity>, Nothing>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Nothing?): Observable<MutableList<ContactEntity>> {
        return repository.getContacts()
    }
}