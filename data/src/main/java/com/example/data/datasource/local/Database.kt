package com.example.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.datasource.local.contacts.dao.ContactDao
import com.example.data.datasource.local.contacts.entity.Contacts
import com.example.data.datasource.local.transfer.dao.TransferDao
import com.example.data.datasource.local.transfer.entity.Transfer

@TypeConverters(Converters::class)
@Database(entities = [Contacts::class, Transfer::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactsDao(): ContactDao
    abstract fun transferDao(): TransferDao
}