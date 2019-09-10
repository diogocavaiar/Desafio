package com.example.domain.repository.contact

import com.example.domain.entity.contact.ContactEntity
import io.reactivex.Observable

interface ContactRepository {

    fun getContacts() : Observable<MutableList<ContactEntity>>

}