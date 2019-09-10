package com.example.desafio.feature.sendtransfer.view.viewstate

sealed class ViewStateSendTransfer {
    data class Success(val value: Boolean) : ViewStateSendTransfer()
    data class Error(val error: String) : ViewStateSendTransfer()
}