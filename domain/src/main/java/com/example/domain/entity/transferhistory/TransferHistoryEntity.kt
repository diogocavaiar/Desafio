package com.example.domain.entity.transferhistory

data class TransferHistoryEntity(val transferHistoryByUser: MutableList<TransferHistoryByUser>,
                                 val transferHistoryGroupedByUser: MutableList<TransferHistoryGroupedByUser>)

data class TransferHistoryByUser(val name: String,
                                 val image: String,
                                 val telephone: String,
                                 val value: Double)

data class TransferHistoryGroupedByUser(val image: String,
                                        val value: Double)