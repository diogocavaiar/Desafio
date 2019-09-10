package com.example.data.datasource.local.mapper

import com.example.data.datasource.local.contacts.entity.Contacts
import com.example.data.mapper.Mapper
import com.example.domain.entity.contact.ContactEntity

class ContactsToContactEntityMapper :
    Mapper<MutableList<Contacts>, MutableList<ContactEntity>> {
    override fun map(from: MutableList<Contacts>): MutableList<ContactEntity> {
        return from.map { contact ->
            ContactEntity(contact.nameClient, contact.telephone, contact.image, contact.clientId)
        }.toMutableList()
    }
}