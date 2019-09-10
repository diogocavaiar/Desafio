package com.example.desafio.di

import com.example.data.datasource.local.AppDatabase
import com.example.data.datasource.local.mapper.TransferToTransferEntityMapper
import com.example.data.datasource.local.transfer.entity.Transfer
import com.example.data.datasource.local.transfer.repository.SendTransferLocal
import com.example.data.datasource.local.transfer.repository.SendTransferLocalImpl
import com.example.data.datasource.remote.mapper.transfer.TransferResponseToTransferEntity
import com.example.data.datasource.remote.sendtransfer.ISendTransferApi
import com.example.data.datasource.remote.sendtransfer.SendTransferApi
import com.example.data.datasource.remote.sendtransfer.SendTransferRemote
import com.example.data.datasource.remote.sendtransfer.SendTransferRemoteImpl
import com.example.data.entity.transfer.TransferResponse
import com.example.data.mapper.Mapper
import com.example.data.repository.sendtransfer.SendTransferRepositoryImpl
import com.example.desafio.feature.sendtransfer.view.SendTransferViewModel
import com.example.domain.entity.transfer.TransferEntity
import com.example.domain.interector.CompletableUseCase
import com.example.domain.interector.transfer.SendTransferUseCase
import com.example.domain.repository.sendtransfer.SendTransferRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mSendTransferModule = module {

    single<CompletableUseCase<SendTransferUseCase.Params>>(named(SEND_TRANFER_USE_CASE)) {
        SendTransferUseCase(get(named(SEND_TRANSFER_REPOSITORY)), get(named(NEW_THREAD)))
    }

    single<SendTransferRepository>(named(SEND_TRANSFER_REPOSITORY)) {
        SendTransferRepositoryImpl(get(named(SEND_TRANSFER_REMOTE)), get(named(SEND_TRANSFER_LOCAL)))
    }

    single<SendTransferRemote>(named(SEND_TRANSFER_REMOTE)) {
        SendTransferRemoteImpl(
            get(named(SEND_TRANSFER_API)),
            get(named(SESSION)))
    }

    single<SendTransferLocal>(named(SEND_TRANSFER_LOCAL)) {
        SendTransferLocalImpl(
            get(named(SESSION)),
            get(named(TRANSFER_DAO))
        )
    }

    single(named(TRANSFER_DAO)) {
        get<AppDatabase>(named(APP_DATABASE)).transferDao()
    }

    single<ISendTransferApi>(named(SEND_TRANSFER_API)) {
        SendTransferApi()
    }

    single<Mapper<MutableList<TransferResponse>, MutableList<TransferEntity>>>(named(MAPPER_TRANSFER_RESPONSE_TO_TRANSFER_ENTITY)) {
        TransferResponseToTransferEntity()
    }

    single<Mapper<MutableList<Transfer>, MutableList<TransferEntity>>>(named(MAPPER_TRANSFER_TO_TRANSFER_ENTITY)) {
        TransferToTransferEntityMapper()
    }

    viewModel {
        SendTransferViewModel(
            get(named(CONTACT_USE_CASE)),
            get(named(SEND_TRANFER_USE_CASE))
        )
    }

}

private const val SEND_TRANFER_USE_CASE = "send_transfer_use_case"
private const val SEND_TRANSFER_REPOSITORY = "send_transfer_repository"
private const val SEND_TRANSFER_REMOTE = "send_transfer_remote"
private const val SEND_TRANSFER_LOCAL = "send_transfer_local"
const val TRANSFER_DAO = "transaction_dao"
private const val SEND_TRANSFER_API = "send_transfer_api"
private const val MAPPER_TRANSFER_RESPONSE_TO_TRANSFER_ENTITY = "mapper_transfer_response_to_transfer_entity"
private const val MAPPER_TRANSFER_TO_TRANSFER_ENTITY = "mapper_transfer_to_transfer_entity"