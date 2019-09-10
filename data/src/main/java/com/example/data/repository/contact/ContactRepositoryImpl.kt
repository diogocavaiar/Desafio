package com.example.data.repository.contact

import com.example.data.datasource.local.contacts.repository.ContactLocal
import com.example.data.datasource.remote.contact.ContactRemote
import com.example.domain.entity.contact.ContactEntity
import com.example.domain.repository.contact.ContactRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class ContactRepositoryImpl(private val remote: ContactRemote,
                            private val local: ContactLocal) : ContactRepository {

    override fun getContacts(): Observable<MutableList<ContactEntity>> {
        return Observable.merge(
            remote.getContacts().doOnNext { contact ->
                local.insertAllContacts(contact)
            }.subscribeOn(Schedulers.io()), local.getAllContacts().subscribeOn(Schedulers.io())
        )
    }
}