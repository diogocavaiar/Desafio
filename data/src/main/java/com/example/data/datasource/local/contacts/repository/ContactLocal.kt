package com.example.data.datasource.local.contacts.repository

import com.example.domain.entity.contact.ContactEntity
import io.reactivex.Observable

interface ContactLocal {

    fun insertAllContacts(contacts: MutableList<ContactEntity>)

    fun getAllContacts(): Observable<MutableList<ContactEntity>>

}