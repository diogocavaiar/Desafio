package com.example.data.datasource.local.transfer.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*

@Entity(tableName = "transfer", primaryKeys = ["client_id", "token", "value", "transferDate"],
    indices = [Index(value = ["client_id", "token", "value", "transferDate"], unique = true)]
)
data class Transfer(@ColumnInfo(name = "client_id") val clientId: String,
                    @ColumnInfo(name = "token") val token: String,
                    @ColumnInfo(name = "value") val value: Double,
                    @ColumnInfo(name = "transferDate") val transferDate: Date = Calendar.getInstance().time)