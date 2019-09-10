package com.example.data.datasource.local.transfer.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.datasource.local.transfer.entity.Transfer
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface TransferDao {

    @Insert
    fun sendTransfer(transfer: Transfer) : Completable

    @Query("select * from transfer")
    fun getAllTransfer(): Observable<MutableList<Transfer>>

    @Query("select client_id, token, sum(value) as value, transferDate from transfer group by client_id")
    fun getAllTransferGropuedbyUser(): Observable<MutableList<Transfer>>

}