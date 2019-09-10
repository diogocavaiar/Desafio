package com.example.desafio.di

import com.example.data.datasource.local.AppDatabase
import com.example.data.datasource.local.contacts.entity.Contacts
import com.example.data.datasource.local.contacts.repository.ContactLocal
import com.example.data.datasource.local.contacts.repository.ContactLocalImpl
import com.example.data.datasource.local.mapper.ContactEntityToContactsMapper
import com.example.data.datasource.local.mapper.ContactsToContactEntityMapper
import com.example.data.datasource.remote.contact.ContactApi
import com.example.data.datasource.remote.contact.ContactApiImpl
import com.example.data.datasource.remote.contact.ContactRemote
import com.example.data.datasource.remote.contact.ContactRemoteImpl
import com.example.data.datasource.remote.mapper.contacts.ContactsMapper
import com.example.data.entity.contacts.ContactsResponse
import com.example.data.mapper.Mapper
import com.example.data.repository.contact.ContactRepositoryImpl
import com.example.domain.entity.contact.ContactEntity
import com.example.domain.interector.ObservableUseCase
import com.example.domain.interector.contacts.GetContactsUseCase
import com.example.domain.repository.contact.ContactRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mContactModule = module {

    single<ObservableUseCase<MutableList<ContactEntity>, Nothing>>(named(CONTACT_USE_CASE)) {
        GetContactsUseCase(get(named(CONTACT_REPOSITORY)), get(named(NEW_THREAD)))
    }

    single<ContactRepository>(named(CONTACT_REPOSITORY)) {
        ContactRepositoryImpl(get(named(CONTACT_REMOTE)), get(named(CONTACT_LOCAL)))
    }

    single<ContactRemote>(named(CONTACT_REMOTE)) {
        ContactRemoteImpl(get(named(CONTACT_API)), get(named(MAPPER_CONTACT_RESPONSE_TO_CONTACT_ENTITY)))
    }

    single<ContactApi>(named(CONTACT_API)) {
        ContactApiImpl()
    }

    single<ContactLocal>(named(CONTACT_LOCAL)) {
        ContactLocalImpl(get(named(CONTACTS_DAO)),
            get(named(MAPPER_CONTACT_ENTITY_TO_CONTACT)),
            get(named(MAPPER_LIST_CONTACT_TO_LIST_CONTACT_ENTITY)))
    }

    single(named(CONTACTS_DAO)) {
        get<AppDatabase>(named(APP_DATABASE)).contactsDao()
    }

    single<Mapper<MutableList<ContactsResponse>, MutableList<ContactEntity>>>(named(MAPPER_CONTACT_RESPONSE_TO_CONTACT_ENTITY)) {
        ContactsMapper()
    }

    single<Mapper<ContactEntity, Contacts>>(named(MAPPER_CONTACT_ENTITY_TO_CONTACT)) {
        ContactEntityToContactsMapper()
    }

    single<Mapper<MutableList<Contacts>, MutableList<ContactEntity>>>(named(MAPPER_LIST_CONTACT_TO_LIST_CONTACT_ENTITY)) {
        ContactsToContactEntityMapper()
    }

}

const val CONTACT_USE_CASE = "contact_use_case"
private const val CONTACT_REPOSITORY = "contact_repository"
private const val CONTACT_REMOTE = "contact_remote"
private const val CONTACT_LOCAL = "contact_local"
private const val CONTACT_API = "contact_api"
const val CONTACTS_DAO = "contacts_dao"
private const val MAPPER_CONTACT_RESPONSE_TO_CONTACT_ENTITY = "mapper_contact_response_to_contact_entity"
private const val MAPPER_CONTACT_ENTITY_TO_CONTACT = "mapper_contact_entity_to_contact"
private const val MAPPER_LIST_CONTACT_TO_LIST_CONTACT_ENTITY = "mapper_list_contact_to_list_contact_entity"