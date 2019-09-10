package com.example.desafio.feature.sendtransfer.view.viewstate

import com.example.domain.entity.contact.ContactEntity

sealed class ViewStateContacts {
    object Loading: ViewStateContacts()
    data class Success(val content: MutableList<ContactEntity>) : ViewStateContacts()
    data class Error(val error: String) : ViewStateContacts()
}