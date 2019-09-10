package com.example.data.datasource.remote.contact

import com.example.domain.entity.contact.ContactEntity
import io.reactivex.Observable

interface ContactRemote {

    fun getContacts(): Observable<MutableList<ContactEntity>>

}