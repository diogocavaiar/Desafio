package com.example.desafio.feature.sendtransfer.view

import android.content.Context
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio.R
import com.example.desafio.feature.base.BaseActivity
import com.example.desafio.feature.sendtransfer.adapter.SendTransferAdapter
import com.example.desafio.feature.sendtransfer.dialog.SendTransferDialog
import com.example.desafio.feature.sendtransfer.view.viewstate.ViewStateContacts
import com.example.desafio.feature.sendtransfer.view.viewstate.ViewStateSendTransfer
import com.example.desafio.util.collapseDialog
import com.example.desafio.util.showDialog
import com.example.desafio.util.showMessageWithSnackBar
import com.example.desafio.util.widget.CustomProgressBar
import com.example.domain.entity.contact.ContactEntity
import kotlinx.android.synthetic.main.activity_send_transfer.*
import org.koin.android.viewmodel.ext.android.viewModel

class SendTransferActivity : BaseActivity() {

    private val mViewModel: SendTransferViewModel by viewModel()
    private val mAdapter = SendTransferAdapter { contact ->
        onClickContact(contact)
    }
    private val customProgressBar: CustomProgressBar by lazy {
        CustomProgressBar(this)
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_send_transfer
    }

    override fun initValues() {
        initRecyclerView()
        initListener()
    }

    private fun initRecyclerView() {
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = mAdapter
    }

    private fun initListener() {
        btnBack.setOnClickListener {
            finish()
        }
    }

    override fun initObserver() {
        mViewModel.getStateContacts().observe(this, Observer {
            checkStateContacts(it)
        })
        mViewModel.getStateSendTransfer().observe(this, Observer {
            checkStateSendTransfer(it)
        })
    }

    private fun checkStateContacts(state: ViewStateContacts?) {
        when(state) {
            is ViewStateContacts.Loading -> {
                showDialog(customProgressBar.create())
            }
            is ViewStateContacts.Success -> {
                mAdapter.setListContact(state.content)
                collapseDialog(customProgressBar.dialog)

            }
            is ViewStateContacts.Error -> {
                collapseDialog(customProgressBar.dialog)
                showMessageWithSnackBar(message = state.error)
            }
        }
    }

    private fun checkStateSendTransfer(state: ViewStateSendTransfer?) {
        when(state) {
            is ViewStateSendTransfer.Success -> {
                if(state.value) {
                    showMessageWithSnackBar(message = getString(R.string.transfer_with_success))
                } else {
                    showMessageWithSnackBar(message = getString(R.string.transfer_with_error))
                }
            }
            is ViewStateSendTransfer.Error -> {
                showMessageWithSnackBar(message = state.error)
            }
        }
    }

    private fun onClickContact(contact: ContactEntity) {
        showDialog(SendTransferDialog(this, contact) { value ->
            mViewModel.sendTranferToContact(contact.id, value)
        }.create())
    }

    companion object {
        fun newInstance(context: Context) {
            context.startActivity(Intent(context, SendTransferActivity::class.java))
        }
    }
}