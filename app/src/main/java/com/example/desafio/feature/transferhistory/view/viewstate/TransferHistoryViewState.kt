package com.example.desafio.feature.transferhistory.view.viewstate

import com.example.domain.entity.transferhistory.TransferHistoryEntity

sealed class TransferHistoryViewState

data class Success(val content: TransferHistoryEntity): TransferHistoryViewState()
data class Error(val error: String) : TransferHistoryViewState()