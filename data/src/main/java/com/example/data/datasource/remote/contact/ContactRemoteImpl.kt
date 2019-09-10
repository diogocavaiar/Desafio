package com.example.data.datasource.remote.contact

import com.example.data.entity.contacts.ContactsResponse
import com.example.data.mapper.Mapper
import com.example.domain.entity.contact.ContactEntity
import io.reactivex.Observable

class ContactRemoteImpl(private val contactApi: ContactApi,
                        private val mapperContactResponseToContactEntity: Mapper<MutableList<ContactsResponse>, MutableList<ContactEntity>>) : ContactRemote {

    override fun getContacts(): Observable<MutableList<ContactEntity>> {
        return contactApi.getContacts()
            .map {
                mapperContactResponseToContactEntity.map(it)
            }
    }

}