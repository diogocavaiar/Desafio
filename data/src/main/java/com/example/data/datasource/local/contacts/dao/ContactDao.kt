package com.example.data.datasource.local.contacts.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.datasource.local.contacts.entity.Contacts
import com.example.domain.entity.contact.ContactEntity
import io.reactivex.Observable

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(contacts: MutableList<Contacts>)

    @Query("select * from Contacts")
    fun getAllContacts(): Observable<MutableList<Contacts>>

}