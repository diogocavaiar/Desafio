package com.example.data.datasource.remote.contact

import com.example.data.entity.contacts.ContactsResponse
import io.reactivex.Observable

interface ContactApi {

    fun getContacts(): Observable<MutableList<ContactsResponse>>

}