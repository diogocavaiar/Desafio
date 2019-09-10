package com.example.data.datasource.local.contacts.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "contacts", indices = arrayOf(Index(value = ["client_id"], unique = true)))
data class Contacts(@ColumnInfo(name = "client_id") val clientId: String,
                    @ColumnInfo(name = "name_client") val nameClient: String,
                    @ColumnInfo(name = "phone") val telephone: String,
                    @ColumnInfo(name = "image") val image: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}