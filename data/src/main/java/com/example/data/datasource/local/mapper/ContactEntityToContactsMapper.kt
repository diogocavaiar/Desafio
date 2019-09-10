package com.example.data.datasource.local.mapper

import com.example.data.datasource.local.contacts.entity.Contacts
import com.example.data.mapper.Mapper
import com.example.domain.entity.contact.ContactEntity

class ContactEntityToContactsMapper : Mapper<ContactEntity, Contacts> {
    override fun map(from: ContactEntity): Contacts {
        return Contacts(from.id, from.name, from.telephone, from.image)
    }
}