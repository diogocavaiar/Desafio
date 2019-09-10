package com.example.desafio.di

import com.example.data.datasource.local.transferhistory.repository.TransferHistoryLocal
import com.example.data.datasource.local.transferhistory.repository.TransferHistoryLocalImpl
import com.example.data.repository.transferhistory.TransferHistoryRepositoryImpl
import com.example.desafio.feature.transferhistory.view.TransferHistoryViewModel
import com.example.domain.entity.transferhistory.TransferHistoryEntity
import com.example.domain.interector.ObservableUseCase
import com.example.domain.interector.transferhistory.GetTransfersHistoryUseCase
import com.example.domain.repository.transferhistory.TransferHistoryRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mTransfershistory = module {

    single<ObservableUseCase<TransferHistoryEntity, Nothing>>(named(GET_TRANSFER_HISTORY_USE_CASE)) {
        GetTransfersHistoryUseCase(get(named(TRANSFER_HISTORY_REPOSITORY)), get(named(NEW_THREAD)))
    }

    single<TransferHistoryRepository>(named(TRANSFER_HISTORY_REPOSITORY)) {
        TransferHistoryRepositoryImpl(get(named(TRANSFER_HISTORY_LOCAL)))
    }

    single<TransferHistoryLocal>(named(TRANSFER_HISTORY_LOCAL)) {
        TransferHistoryLocalImpl(get(named(CONTACTS_DAO)), get(named(TRANSFER_DAO)))
    }

    viewModel {
        TransferHistoryViewModel(get(named(GET_TRANSFER_HISTORY_USE_CASE)))
    }

}

private const val GET_TRANSFER_HISTORY_USE_CASE = "get_transfer_hisotry_use_case"
private const val TRANSFER_HISTORY_REPOSITORY = "transfer_history_repository"
private const val TRANSFER_HISTORY_LOCAL = "transfer_history_local"