package com.example.data.datasource.remote.mapper.contacts

import com.example.data.entity.contacts.ContactsResponse
import com.example.data.mapper.Mapper
import com.example.domain.entity.contact.ContactEntity

class ContactsMapper :
    Mapper<MutableList<ContactsResponse>, MutableList<ContactEntity>> {

    override fun map(from: MutableList<ContactsResponse>): MutableList<ContactEntity> {
        return from.map {
            ContactEntity(it.name, it.telephone, it.image, it.id)
        }.toMutableList()
    }
}