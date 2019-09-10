package com.example.desafio.feature.transferhistory.view

import android.content.Context
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio.R
import com.example.desafio.feature.base.BaseActivity
import com.example.desafio.feature.transferhistory.adapter.byuser.TransferHistoryAdapter
import com.example.desafio.feature.transferhistory.adapter.groupedbyuser.TransferHistoryGroupedByUserAdapter
import com.example.desafio.feature.transferhistory.view.viewstate.Error
import com.example.desafio.feature.transferhistory.view.viewstate.Success
import com.example.desafio.feature.transferhistory.view.viewstate.TransferHistoryViewState
import com.example.desafio.util.showMessageWithSnackBar
import kotlinx.android.synthetic.main.activity_transfer_history.*
import org.koin.android.viewmodel.ext.android.viewModel


class TransferHistoryActivity : BaseActivity() {

    private val mViewModel: TransferHistoryViewModel by viewModel()
    private val mAdapterTransferUser =
        TransferHistoryAdapter()
    private val mAdapterTransferUserGroupedByUserAdapter =
        TransferHistoryGroupedByUserAdapter()

    override fun getLayoutRes(): Int {
        return R.layout.activity_transfer_history
    }

    override fun initValues() {
        initListener()
        initRecyclerView()
    }

    override fun initObserver() {
        mViewModel.getState().observe(this, Observer {state ->
            checkState(state)
        })
    }

    private fun checkState(state: TransferHistoryViewState?) {
        when(state) {
            is Success -> {
                mAdapterTransferUser.setListTransferHistory(state.content.transferHistoryByUser)
                mAdapterTransferUserGroupedByUserAdapter.setListTransferHistoryGroupedByUser(state.content.transferHistoryGroupedByUser)
            }
            is Error -> {
                showMessageWithSnackBar(message = state.error)
            }
        }
    }

    private fun initRecyclerView() {
        initRecyclerViewTransferUser()
        initRecyclerViewTransferGroupedByUser()
    }

    private fun initRecyclerViewTransferUser() {
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = mAdapterTransferUser
    }

    private fun initRecyclerViewTransferGroupedByUser() {
        recyclerViewChart.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewChart.adapter = mAdapterTransferUserGroupedByUserAdapter
    }

    private fun initListener() {
        btnBack.setOnClickListener {
            finish()
        }
    }

    companion object {
        fun newInstance(context: Context) {
            context.startActivity(Intent(context, TransferHistoryActivity::class.java))
        }
    }
}