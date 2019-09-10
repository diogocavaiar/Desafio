package com.example.data.datasource.local.contacts.repository

import com.example.data.datasource.local.contacts.dao.ContactDao
import com.example.data.datasource.local.contacts.entity.Contacts
import com.example.data.mapper.Mapper
import com.example.domain.entity.contact.ContactEntity
import io.reactivex.Observable

class ContactLocalImpl(private val contactsDao: ContactDao,
                       private val mapperContactEntityToContacts: Mapper<ContactEntity, Contacts>,
                       private val mapperContactsToContactEntity: Mapper<MutableList<Contacts>, MutableList<ContactEntity>>) : ContactLocal {

    override fun insertAllContacts(contacts: MutableList<ContactEntity>) {
        contactsDao.insertAll(contacts.map {
            mapperContactEntityToContacts.map(it)
        }.toMutableList())
    }

    override fun getAllContacts(): Observable<MutableList<ContactEntity>> {
        return contactsDao.getAllContacts()
            .map {
                mapperContactsToContactEntity.map(it)
            }
    }

}