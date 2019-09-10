package com.example.data.datasource.local.transferhistory.repository

import com.example.data.datasource.local.contacts.dao.ContactDao
import com.example.data.datasource.local.contacts.entity.Contacts
import com.example.data.datasource.local.transfer.dao.TransferDao
import com.example.data.datasource.local.transfer.entity.Transfer
import com.example.domain.entity.transferhistory.TransferHistoryByUser
import com.example.domain.entity.transferhistory.TransferHistoryEntity
import com.example.domain.entity.transferhistory.TransferHistoryGroupedByUser
import io.reactivex.Observable
import io.reactivex.Observable.zip
import io.reactivex.functions.Function3

class TransferHistoryLocalImpl(private val contactsDao: ContactDao,
                               private val transferDao: TransferDao) : TransferHistoryLocal {

    override fun getTransferHistory(): Observable<TransferHistoryEntity> {
        return zip(
            transferDao.getAllTransfer(),
            transferDao.getAllTransferGropuedbyUser(),
            contactsDao.getAllContacts(),
            Function3<MutableList<Transfer>, MutableList<Transfer>, MutableList<Contacts>, TransferHistoryEntity> { transfersByUser, transferGroupedByUser, contacts ->
                filterContactsWhoHaveTransfer(transfersByUser, transferGroupedByUser, contacts)
            }
        )
    }

    private fun filterContactsWhoHaveTransfer(transfersByUser: MutableList<Transfer>, transferGroupedByUser: MutableList<Transfer>, contacts: MutableList<Contacts>): TransferHistoryEntity {
        return TransferHistoryEntity(getListTransferHistory(transfersByUser, contacts), getListTransferGroupedByUser(transferGroupedByUser, contacts))
    }

    private fun getListTransferGroupedByUser(transferGroupedByUser: MutableList<Transfer>, contacts: MutableList<Contacts>): MutableList<TransferHistoryGroupedByUser> {
        var listTransferGroupedByUser: MutableList<TransferHistoryGroupedByUser> = mutableListOf()

        contacts.forEach loopContacts@ { contacts ->
            transferGroupedByUser.forEach loopTransfers@ { transfer ->
                if(contacts.clientId.isEmpty()) return@loopContacts

                if(transfer.clientId.isEmpty()) return@loopTransfers

                if(contacts.clientId == transfer.clientId)

                    if(contacts.clientId == transfer.clientId)
                        listTransferGroupedByUser.add(TransferHistoryGroupedByUser(contacts.image, transfer.value))
            }
        }
        return listTransferGroupedByUser.sortedByDescending  { it.value }.toMutableList()
    }

    private fun getListTransferHistory(transfersByUser: MutableList<Transfer>, contacts: MutableList<Contacts>): MutableList<TransferHistoryByUser> {
        val listTransferHistory: MutableList<TransferHistoryByUser> = mutableListOf()

        contacts.forEach loopContacts@ { contacts ->
            transfersByUser.forEach loopTransfers@ { transfer ->
                if(contacts.clientId.isEmpty()) return@loopContacts

                if(transfer.clientId.isEmpty()) return@loopTransfers

                if(contacts.clientId == transfer.clientId)

                    if(contacts.clientId == transfer.clientId)
                        listTransferHistory.add(TransferHistoryByUser(contacts.nameClient,
                            contacts.image,
                            contacts.telephone,
                            transfer.value))
            }
        }
        return listTransferHistory
    }
}